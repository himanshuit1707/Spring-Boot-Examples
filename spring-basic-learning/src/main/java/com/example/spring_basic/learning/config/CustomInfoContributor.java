package com.example.spring_basic.learning.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> appDetails = new HashMap<>();
        appDetails.put("name", "Student Management Service");
        appDetails.put("version", "1.0.0");
        appDetails.put("developer", "Himanshu Kumar");
        builder.withDetail("application", appDetails);
    }
}