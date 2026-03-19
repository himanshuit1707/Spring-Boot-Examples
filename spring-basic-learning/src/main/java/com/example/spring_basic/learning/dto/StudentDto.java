package com.example.spring_basic.learning.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String courseName;
}
