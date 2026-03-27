package com.example.jms.demo.controller;

import com.example.jms.demo.messaging.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageProducer producer;

    @Autowired
    public MessageController(MessageProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        producer.sendTopicMessage(message);
        return "Message sent: " + message;
    }
}