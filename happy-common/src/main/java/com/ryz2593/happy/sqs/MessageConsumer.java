package com.ryz2593.happy.sqs;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class MessageConsumer {
    private static final Log logger = LogFactory.getLog(MessageConsumer.class);

    private final static int DEFAULT_MAX_NUMBERS = 5;
    private final static boolean DEFAULT_IS_STOP_WHEN_EXCEPTION = false;

    private volatile boolean started = false;
    private volatile boolean isRun = true;

    private String queueName;

    private MessageHandler messageHandler;

    private Integer maxNumbers;

    private boolean isStopWhenException = DEFAULT_IS_STOP_WHEN_EXCEPTION;


    public MessageConsumer() {
    }

    public MessageConsumer(String queueName, MessageHandler messageHandler) {
        this(DEFAULT_MAX_NUMBERS, messageHandler, queueName);
    }

    public MessageConsumer(int maxNumbers, MessageHandler messageHandler, String queueName) {
        this.maxNumbers = maxNumbers;
        this.messageHandler = messageHandler;
        this.queueName = queueName;
        if (this.maxNumbers < 1) {
            this.maxNumbers = 1;
        } else if (this.maxNumbers > 10) {
            this.maxNumbers = 10;
        }
    }

    public MessageConsumer(boolean isStopWhenException, Integer maxNumbers, MessageHandler messageHandler, String queueName) {
        this(maxNumbers, messageHandler, queueName);
        this.isStopWhenException = isStopWhenException;
    }

    public void start() {
        synchronized (this) {
            if (started) {
                return;
            }
            started = true;
        }
        final AmazonSQS sqs = new AmazonSQSClient(new ClasspathPropertiesFileCredentialsProvider("AwsCredentialsSQS.properties"));
        sqs.setRegion(Region.getRegion(Regions.US_EAST_1));
        final String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl).withMaxNumberOfMessages(maxNumbers);
        logger.info("MessageConsumer completed start,quene name is " + queueName);

        while (isRun) {

            try {
                List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();

                if (CollectionUtils.isNotEmpty(messages)) {
                    messageHandler.execute(messages);

                    List<DeleteMessageBatchRequestEntry> entries = Lists.newArrayList();
                    for (Message message : messages) {
                        DeleteMessageBatchRequestEntry deleteMessageBatchRequestEntry = new DeleteMessageBatchRequestEntry(message.getMessageId(), message.getReceiptHandle());
                        entries.add(deleteMessageBatchRequestEntry);
                    }

                    sqs.deleteMessageBatch(new DeleteMessageBatchRequest(queueUrl).withEntries(entries));

                }
            } catch (AmazonServiceException ase) {
                logger.error("\nCaught an AmazonServiceException, which means your request made it  to Amazon SQS, but was rejected"

                        + "\nError Message:    " + ase.getMessage()
                        + "\nHTTP Status Code: " + ase.getStatusCode()
                        + "\nAWS Error Code:   " + ase.getErrorCode()
                        + "\nError Type:       " + ase.getErrorType()
                        + "\nRequest ID:       " + ase.getRequestId());
            } catch (AmazonClientException ace) {
                logger.error("\nCaught an AmazonClientException, which means the client encountered "
                        + "\nError Message: " + ace.getMessage());
            } catch (Exception e) {
                logger.error("MessageHandler " + messageHandler.getClass() + " Error:", e);
                if (isStopWhenException) {
                    stop();
                }
            }
        }


    }

    public void stop() {
        isRun = false;
    }


    public boolean isStopWhenException() {
        return isStopWhenException;
    }

    public void setIsStopWhenException(boolean isStopWhenException) {
        this.isStopWhenException = isStopWhenException;
    }

    public Integer getMaxNumbers() {
        return maxNumbers;
    }

    public void setMaxNumbers(Integer maxNumbers) {
        this.maxNumbers = maxNumbers;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
