package com.example.spring_basic.learning;

import com.example.spring_basic.learning.entity.Student;
import com.example.spring_basic.learning.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBasicLearningApplicationTests {

    @Autowired
    private StudentRepo studentRepo;

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

}
