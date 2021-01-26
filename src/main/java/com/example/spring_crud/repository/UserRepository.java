package com.example.spring_crud.repository;

import com.example.spring_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Long> {
}
