package com.ryz2593.happy.sqs;

import com.amazonaws.services.sqs.model.Message;

import java.util.List;

public interface MessageHandler {
    void execute(List<Message> messageList);
}
