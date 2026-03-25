package com.example.spring_basic.learning.repo;

import com.example.spring_basic.learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}