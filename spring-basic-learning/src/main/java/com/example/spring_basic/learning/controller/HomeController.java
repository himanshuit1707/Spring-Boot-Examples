package com.example.spring_basic.learning.controller;

import com.example.spring_basic.learning.dto.StudentDto;
import com.example.spring_basic.learning.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Himanshu");
        return "home"; // loads home.html
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<String> users = Arrays.asList("Ram","Shyam","Amit");
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/student")
    public String getStudent(Model model) {
        StudentDto student = StudentDto.builder().id(1L).email("abc@gmail.com").
                name("Himanshu").courseName("MCA").build();
        model.addAttribute("student", student);
        //this will send student object to student.html
        return "student"; // student.html
    }

    @GetMapping("/students")
    public String getStudentList(Model model) {
        StudentDto student1 = StudentDto.builder().id(1L).email("abc@gmail.com").
                name("Himanshu").courseName("MCA").build();
        StudentDto student2 = StudentDto.builder().id(2L).email("zyz@gmail.com").
                name("Kumar").courseName("BCA").build();
        StudentDto student3 = StudentDto.builder().id(3L).email("123@gmail.com").
                name("Ranjan").courseName("KCA").build();

        List<StudentDto> studentDtoList=new ArrayList<>();
        studentDtoList.add(student1);
        studentDtoList.add(student2);
        studentDtoList.add(student3);
        model.addAttribute("students", studentDtoList);
        //this will send students list to students.html
        return "students"; // students.html
    }

    @GetMapping("/student-form")
    public String showForm(Model model) {
        model.addAttribute("student", StudentDto.builder().id(1L).
                courseName("MCA").email("abc@email.com").name("Himanshu").build());
        return "student-form";
    }

    // Handle submit
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") StudentDto studentDto) {
        System.out.println("Name: " + studentDto.getName());
        System.out.println("Email: " + studentDto.getEmail());
        System.out.println("Email: " + studentDto.getCourseName());
        return "result";
    }
}