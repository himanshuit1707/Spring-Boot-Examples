package com.example.spring_basic.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}