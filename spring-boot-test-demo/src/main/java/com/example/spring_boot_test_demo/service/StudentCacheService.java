package com.example.spring_boot_test_demo.service;


import com.example.spring_boot_test_demo.dto.StudentDto;
import com.example.spring_boot_test_demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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

    @CacheEvict(value = "students", key = "#id")
    public void deleteStudent(Long id) {
        System.out.println("Cache cleared for id: " + id);
        studentService.deleteStudent(id);
    }

    @CachePut(value = "students", key = "#studentDto.id")
    public Student updateStudentCache(StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }

}
