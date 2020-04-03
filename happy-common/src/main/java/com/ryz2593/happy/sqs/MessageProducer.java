package com.ryz2593.happy.sqs;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.common.collect.Maps;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageProducer {
    private static final Log logger = LogFactory.getLog(MessageProducer.class);
    private AmazonSQS sqs;
    private ConcurrentMap<String, String> queueUrlMap = Maps.newConcurrentMap();
    private ExecutorService executorService = Executors.newFixedThreadPool(8);

    public void init() {
        sqs = new AmazonSQSClient(new ClasspathPropertiesFileCredentialsProvider("AwsCredentialsSQS.properties"));
        sqs.setRegion(Region.getRegion(Regions.US_EAST_1));
        List<String> queueUrlList = sqs.listQueues().getQueueUrls();
        for (String queueUrl : queueUrlList) {
            String queueName = queueUrl.substring(queueUrl.lastIndexOf("/") + 1);
            queueUrlMap.put(queueName, queueUrl);
        }
    }

    public void sendMessage(String queueName, String content) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String queueUrl = queueUrlMap.get(queueName);
                    if (queueUrl == null) {
                        queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
                        queueUrlMap.putIfAbsent(queueName, queueUrl);
                    }

                    sqs.sendMessage(new SendMessageRequest(queueUrl, content));
                } catch (Exception e) {
                    logger.error("send message Error,message content is:" + content, e);
                }
            }
        });

    }


/**
    public void sendUserAccessLogMessage(String accessLogQueneName, SysParameter sysParameter) {
        if (sysParameter != null) {
            Integer userId = sysParameter.getUserId();
            if (userId == null || userId <= 0) {
                return;
            }

            Integer platform = PlatformEnum.getValidPlatform(sysParameter.getClientOs());
            AppTypeEnum appTypeEnum = AppTypeEnum.P365;
            if (sysParameter.getAppKey().equals("arcappkey")) {
                appTypeEnum = AppTypeEnum.PROTOOL;
            }
            //构造消息对象
            UserAccessLogMessage userAccessLogMessage = BeanCopyUtil.map(sysParameter, UserAccessLogMessage.class);
            //设置应用类型，可选AppTypeEnum.P365和AppTypeEnum.PROTOOL
            userAccessLogMessage.setAppType(appTypeEnum.getValue());
            userAccessLogMessage.setMi(sysParameter.getImei());
            userAccessLogMessage.setPlatform(platform);

            sendMessage(accessLogQueneName, JsonUtil.toJson(userAccessLogMessage));

        }


    }
 */

    public static void main(String[] a) {
//        UserAccessLogMessage userAccessLogMessage = new UserAccessLogMessage();
//        userAccessLogMessage.setAppType(1);
//
//        UploadPushTokenMessage uploadPushTokenMessage = BeanCopyUtil.map(userAccessLogMessage, UploadPushTokenMessage.class);
//        System.out.print(uploadPushTokenMessage.getAppType());
    }

}
