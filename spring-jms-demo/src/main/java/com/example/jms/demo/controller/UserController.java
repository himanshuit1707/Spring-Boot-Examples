package com.example.jms.demo.controller;

import com.example.jms.demo.dto.User;
import com.example.jms.demo.messaging.UserProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Controller", description = "APIs for User management")
@RestController
public class UserController {

    private final UserProducer userProducer;

    @Autowired
    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @Operation(summary = "Testing of user message using JMS", description = "Sending user object Java Messaging services using JMS API")
    @PostMapping("/send-user")
    public @ApiResponse(description = "String Object") String sendUser(@RequestBody User user) {
        userProducer.sendUser(user);
        return "User message sent!";
    }
}