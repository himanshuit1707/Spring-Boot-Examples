package com.example.spring_basic.learning.config;


import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
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