package com.example.jms.demo.messaging;

import com.example.jms.demo.dto.User;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @JmsListener(destination = "user-queue")
    public void receive(User user) {
        System.out.println("Received User: " + user.getName() + ", " + user.getEmail());
    }
}