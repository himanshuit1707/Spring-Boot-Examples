package com.example.spring_basic.learning;

import com.example.spring_basic.learning.entity.User;
import com.example.spring_basic.learning.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameter;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBasicLearningApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobOperator jobOperator;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Job job;

    @Test
    void contextLoads() {
    }

    @Test
    void testDatabase() {
        User user = User.builder()
                .name("Himanshu")
                .email("himanshu@example.com")
                .build();
        User savedUser = userRepository.save(user);
        Assertions.assertNotNull(userRepository.findById(savedUser.getId()).orElse(null));
    }

   // @Test
    void testRestClient() {
        // Assuming there's a controller mapping for /api/v1/user
        User user = restTemplate.getForObject("/api/v1/user?id=1", User.class);
        // Note: This test assumes data exists or is mocked; updated to use User entity.
        if (user != null) {
            Assertions.assertNotNull(user.getName());
        }
    }


}
