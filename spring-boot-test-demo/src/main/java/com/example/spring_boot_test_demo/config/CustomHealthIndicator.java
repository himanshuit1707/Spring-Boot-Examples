package com.example.spring_boot_test_demo.config;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        boolean serviceUp = checkService();

        if (serviceUp) {
            return Health.up()
                    .withDetail("Service", "Running Successfully")
                    .build();
        } else {
            return Health.down()
                    .withDetail("Service", "Service is Down")
                    .build();
        }
    }

    private boolean checkService() {
        // Custom logic (DB/API/file check etc.)
        return true;
    }
}