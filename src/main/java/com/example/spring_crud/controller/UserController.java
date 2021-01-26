package com.example.spring_crud.controller;

import com.example.spring_crud.model.User;
import com.example.spring_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("createUser")
    public User createUser(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @GetMapping("findUserById/{userId}")
    public Optional<User> findUserById(@PathVariable("userId") long userId){
        return userService.findById(userId);
    }

    @DeleteMapping("deleteUserbyId/{userId}")
    public void deleteUserByid(@PathVariable("userId") long userId){
        userService.deleteById(userId);
    }
}
