package com.ryz2593.happy.study.sqs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ryz2593
 * @date 2020/2/27 18:07
 */
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
        logger.info("MessageConsumer completed start,quene name is " + queueName);

        while (isRun) {

            try {
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
