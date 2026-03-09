package com.example.spring_basic.learning.controller;


import com.example.spring_basic.learning.dto.StudentDto;
import com.example.spring_basic.learning.entity.Student;
import com.example.spring_basic.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/api/v1/student")
    public ResponseEntity<Object> saveStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.save(studentDto);
        if (Objects.isNull(student)) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/api/v1/student")
    public ResponseEntity<Object> updateStudent(@RequestBody StudentDto studentDto) {
        Student student = studentService.updateStudent(studentDto);
        if (Objects.isNull(student)) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        return ResponseEntity.ok(student);
    }


    @GetMapping("/api/v1/student")
    public ResponseEntity<Object> getStudent(@RequestParam Long id) {
        Student student = studentService.getStudent(id);
        if (Objects.isNull(student)) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/api/v1/student")
    public ResponseEntity<Object> deleteStudent(@RequestParam Long id) {
        Student student = studentService.getStudent(id);
        if (Objects.isNull(student)) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
