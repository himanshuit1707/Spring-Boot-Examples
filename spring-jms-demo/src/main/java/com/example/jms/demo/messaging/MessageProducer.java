package com.example.jms.demo.messaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public MessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    private static final String QUEUE = "my-queue";

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(QUEUE, message);
        System.out.println("Sent message: " + message);
    }
}