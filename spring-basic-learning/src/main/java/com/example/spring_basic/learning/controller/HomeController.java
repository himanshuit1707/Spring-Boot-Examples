package com.example.spring_basic.learning.controller;

import com.example.spring_basic.learning.dto.StudentDto;
import com.example.spring_basic.learning.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
}