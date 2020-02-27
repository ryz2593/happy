package com.ryz2593.happy.study.spring;

import com.ryz2593.happy.study.sqs.Message;
import com.ryz2593.happy.study.sqs.MessageConsumer;
import com.ryz2593.happy.study.sqs.MessageHandler;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ryz2593
 * @date 2020/2/27 18:05
 */
@Component
public class UserEmailHandlerTask extends Thread {

    private final static String QUEUENAME = "ses-queue";
    @Override
    public void run() {
        new MessageConsumer( 1,new MessageHandler(){
            @Override
            public void execute(List<Message> list) {
                //处理从队列中读取到的消息列表
            }
        }, QUEUENAME).start();
    }
}
