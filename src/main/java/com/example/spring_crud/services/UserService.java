package com.example.spring_crud.services;

import com.example.spring_crud.model.User;

public interface UserService {

    User saveOrUpdate (User user);

    User findById(Long id);

    void deleteById(Long id);
}
