package com.example.jms.demo.messaging;

import com.example.jms.demo.dto.User;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final JmsTemplate jmsTemplate;

    public UserProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendUser(User user) {
        jmsTemplate.convertAndSend("user-queue", user);
        System.out.println("Sent User: " + user.getName());
    }
}
