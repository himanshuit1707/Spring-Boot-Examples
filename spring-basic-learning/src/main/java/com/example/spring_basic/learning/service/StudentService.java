package com.example.spring_basic.learning.service;


import com.example.spring_basic.learning.dto.StudentDto;
import com.example.spring_basic.learning.entity.Student;
import com.example.spring_basic.learning.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ObjectStreamClass;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student save(StudentDto studentDto) {
        if (Objects.isNull(studentDto)) {
            return null;
        }
        if (Objects.nonNull(studentDto.getId())) {
            return null;
        }
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setCourseName(studentDto.getCourseName());
        return studentRepo.save(student);
    }

    public Student getStudent(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        return studentOptional.orElse(null);
    }

    public void deleteStudent(Long id) {
        Student student = getStudent(id);
        studentRepo.delete(student);
    }

    public Student updateStudent(StudentDto studentDto) {
        if (Objects.isNull(studentDto)|| Objects.isNull(studentDto.getId())) {
            return null;
        }
        Student student = getStudent(studentDto.getId());
        if (Objects.isNull(student)) {
            return null;
        }
        if (Objects.nonNull(studentDto.getName())) {
            student.setName(studentDto.getName());
        }
        if (Objects.nonNull(studentDto.getEmail())) {
            student.setEmail(studentDto.getEmail());
        }
        if (Objects.nonNull(studentDto.getCourseName())) {
            student.setCourseName(studentDto.getCourseName());
        }
        return studentRepo.save(student);
    }


}
