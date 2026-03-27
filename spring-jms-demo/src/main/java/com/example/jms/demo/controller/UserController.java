package com.example.jms.demo.controller;

import com.example.jms.demo.dto.User;
import com.example.jms.demo.messaging.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserProducer userProducer;

    @Autowired
    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping("/send-user")
    public String sendUser(@RequestBody User user) {
        userProducer.sendUser(user);
        return "User message sent!";
    }
}