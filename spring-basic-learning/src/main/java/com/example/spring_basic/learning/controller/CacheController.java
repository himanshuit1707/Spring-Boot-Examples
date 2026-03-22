package com.example.spring_basic.learning.controller;

import com.example.spring_basic.learning.entity.Student;
import com.example.spring_basic.learning.service.StudentCacheService;
import com.example.spring_basic.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CacheController {

    private final StudentCacheService studentCacheService;

    @Autowired
    public CacheController(StudentCacheService studentCacheService) {
        this.studentCacheService = studentCacheService;
    }

    @GetMapping("/api/v1/student_cache")
    public ResponseEntity<Object> getStudent(@RequestParam Long id) {
        Student student = studentCacheService.getStudentById(id);
        if (Objects.isNull(student)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

}
