package com.example.spring_basic.learning.controller;

import com.example.spring_basic.learning.dto.StudentDto;
import com.example.spring_basic.learning.entity.Student;
import com.example.spring_basic.learning.service.StudentCacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/v1/student_cache")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentDto studentDto) {
        Student student = studentCacheService.updateStudentCache(studentDto);
        if (Objects.isNull(student)) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/api/v1/student_cache")
    public ResponseEntity<Object> deleteStudent(@RequestParam Long id) {
        Student student = studentCacheService.getStudentById(id);
        if (Objects.isNull(student)) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        studentCacheService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }


}
