package com.example.spring_boot_test_demo;


import com.example.spring_boot_test_demo.dto.StudentDto;
import com.example.spring_boot_test_demo.entity.Student;
import com.example.spring_boot_test_demo.repo.StudentRepo;
import com.example.spring_boot_test_demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enable Mockito annotations
class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo; // Mocked dependency

    @InjectMocks
    private StudentService studentService; // Service under test

    @Test
    void testSaveStudent_Success() {
        StudentDto dto = new StudentDto();
        dto.setName("Himanshu Kumar");
        dto.setEmail("abc@gmail.com");
        dto.setCourseName("MCA");
        Student savedStudent = Student.builder()
                .id(1L)
                .name(dto.getName())
                .email(dto.getEmail())
                .courseName(dto.getCourseName())
                .build();
        Mockito.when(studentRepo.save(Mockito.any(Student.class)))
                .thenReturn(savedStudent);
        Student result = studentService.save(dto);
        assertNotNull(result);
        assertEquals("Himanshu Kumar", result.getName());
        assertEquals("abc@gmail.com", result.getEmail());
        assertEquals(1L, result.getId());
    }

    @Test
    void testSaveStudent_Failure_NullName() {
        StudentDto dto = new StudentDto();
        dto.setName(""); // invalid input
        Mockito.when(studentRepo.save(Mockito.any(Student.class))).thenReturn(null);
        Student result = studentService.save(dto);
        assertNull(result); // should return null for invalid input
    }

    @Test
    void testGetStudent_Found() {
        Student student = Student.builder()
                .id(1L)
                .name("Himanshu")
                .email("abc@gmail.com")
                .courseName("MCA")
                .build();

        Mockito.when(studentRepo.findById(1L))
                .thenReturn(Optional.of(student));
        Student result = studentService.getStudent(1L);
        assertNotNull(result);
        assertEquals("Himanshu", result.getName());
    }

    @Test
    void testGetStudent_NotFound() {
        Mockito.when(studentRepo.findById(1L))
                .thenReturn(Optional.empty());
        Student result = studentService.getStudent(1L);
        assertNull(result); // service returns null if student not found
    }

    @Test
    void testDeleteStudent_Success() {
        // Arrange: create a student
        Student student = Student.builder()
                .id(1L)
                .name("Himanshu")
                .email("abc@gmail.com")
                .courseName("MCA")
                .build();
        // Spy service to mock getStudent
        StudentService spyService = Mockito.spy(studentService);
        doReturn(student).when(spyService).getStudent(1L);
        // Act: delete student
        spyService.deleteStudent(1L);
        // Assert: verify delete was called exactly once
        verify(studentRepo, times(1)).delete(student);
    }

    @Test
    void testDeleteStudent_NotFound() {
        // Spy service to return null for getStudent
        StudentService spyService = Mockito.spy(studentService);
        doReturn(null).when(spyService).getStudent(1L);
        // Act
        spyService.deleteStudent(1L);
        // Assert: delete should never be called
        verify(studentRepo, never()).delete(any());
    }
}