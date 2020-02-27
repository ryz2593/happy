package com.ryz2593.happy.study.sqs;

import java.util.List;

/**
 * @author ryz2593
 * @date 2020/2/27 18:09
 */
public interface MessageHandler {
    void execute(List<Message> messageList);
}
