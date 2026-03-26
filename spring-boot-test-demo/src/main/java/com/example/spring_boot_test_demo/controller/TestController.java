package com.example.spring_boot_test_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/v1/test")
    public ResponseEntity<Object> testFirstRequest() {
        return ResponseEntity.ok("Server is running");
    }
}
