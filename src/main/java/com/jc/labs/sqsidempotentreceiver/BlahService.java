package com.jc.labs.sqsidempotentreceiver;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

public class BlahService implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println("***");
        System.out.println("*** " + message.getPayload());

    }
    
}
