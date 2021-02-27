package com.example.spring_crud.controller;

import com.example.spring_crud.mapper.UserDTO;
import com.example.spring_crud.mapper.UserMapper;
import com.example.spring_crud.model.User;
import com.example.spring_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("createUser")
    public User createUser(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @GetMapping("findUserById/{userId}")
    public UserDTO findUserById(@PathVariable("userId") long userId){
        User userData = userService.findById(userId);
        return UserMapper.toUserDTO(userData);
    }

    @DeleteMapping("deleteUserbyId/{userId}")
    public void deleteUserByid(@PathVariable("userId") long userId){
        userService.deleteById(userId);
    }
}
