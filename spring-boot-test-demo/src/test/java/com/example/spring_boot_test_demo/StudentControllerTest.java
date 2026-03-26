package com.example.spring_boot_test_demo;

import com.example.spring_boot_test_demo.controller.StudentController;
import com.example.spring_boot_test_demo.dto.StudentDto;
import com.example.spring_boot_test_demo.entity.Student;
import com.example.spring_boot_test_demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class Config {
        @Bean
        public StudentService studentService() {
            return Mockito.mock(StudentService.class);
        }
    }

    @Test
    void testGetStudent() throws Exception {
        Student student = Student.builder()
                .id(1L)
                .name("Himanshu Kumar")
                .email("abc@gmail.com")
                .courseName("MCA")
                .build();

        Mockito.when(studentService.getStudent(1L)).thenReturn(student);

        mockMvc.perform(get("/api/v1/student?id=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Himanshu Kumar"));
    }

    @Test
    void testSaveStudent_Success() throws Exception {
        // Prepare DTO
        StudentDto studentDto = new StudentDto();
        studentDto.setName("Himanshu Kumar");
        studentDto.setEmail("abc@gmail.com");
        studentDto.setCourseName("MCA");

        // Mock service
        Student savedStudent = Student.builder()
                .id(1L)
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .courseName(studentDto.getCourseName())
                .build();

        Mockito.when(studentService.save(Mockito.any(StudentDto.class)))
                .thenReturn(savedStudent);

        // Perform POST request
        mockMvc.perform(post("/api/v1/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Himanshu Kumar"))
                .andExpect(jsonPath("$.email").value("abc@gmail.com"));
    }

    @Test
    void testSaveStudent_BadRequest() throws Exception {
        // Prepare DTO
        StudentDto studentDto = new StudentDto();
        studentDto.setName(""); // invalid input

        // Mock service returns null
        Mockito.when(studentService.save(Mockito.any(StudentDto.class)))
                .thenReturn(null);

        mockMvc.perform(post("/api/v1/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDto)))
                .andExpect(status().isBadRequest());
    }

}



