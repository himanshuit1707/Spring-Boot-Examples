package com.example.spring_basic.learning;

import com.example.spring_basic.learning.entity.Student;
import com.example.spring_basic.learning.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringBasicLearningApplicationTests {

    @Autowired
    private StudentRepo studentRepo;

    private final RestTemplate restTemplate;

    @Value("${server.url}")
    private String serverUrl;

    @Autowired
    public SpringBasicLearningApplicationTests(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    void contextLoads() {
    }


    @Test
    void testDatabase() {
        Student student = new Student();
        student.setName("Himanshu");
        student.setCourseName("Java");
        Student saveStudent = studentRepo.save(student);
        Assertions.assertNotNull(studentRepo.findById(saveStudent.getId()).orElse(null));
    }

    @Test
    void testRestClient() {
        Student student = restTemplate.getForObject(serverUrl+"/api/v1/student?id=2", Student.class);
        Assertions.assertNotNull(student);
        Assertions.assertEquals("Himanshu Kumar", student.getName());
    }

}
