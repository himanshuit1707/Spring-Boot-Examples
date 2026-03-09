package com.example.spring_basic.learning.repo;

import com.example.spring_basic.learning.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findAll();

    Optional<Student> findById(Long aLong);
}
