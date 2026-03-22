package com.example.spring_basic.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBasicLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicLearningApplication.class, args);
    }

}
