package com.example.spring_crud.services;

import com.example.spring_crud.model.User;

import java.util.Optional;

public interface UserService {

    User saveOrUpdate (User user);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
