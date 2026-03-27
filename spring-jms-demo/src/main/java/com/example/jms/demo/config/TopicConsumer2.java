package com.example.jms.demo.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer2 {

    @JmsListener(destination = "my-topic", containerFactory = "topicFactory")
    public void receive(String message) {
        System.out.println("TopicConsumer2 received: " + message);
    }
}