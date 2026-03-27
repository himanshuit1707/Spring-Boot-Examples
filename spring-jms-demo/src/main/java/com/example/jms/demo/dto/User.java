package com.example.jms.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private String email;

    // Getters & Setters
}