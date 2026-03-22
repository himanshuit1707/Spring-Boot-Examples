package com.example.spring_basic.learning.service;

import com.example.spring_basic.learning.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentCacheService {

    private final StudentService studentService;

    @Autowired
    public StudentCacheService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Cacheable(value = "students", key = "#id")
    public Student getStudentById(Long id) {
        simulateSlowService();
        return studentService.getStudent(id);
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000); // simulate delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
