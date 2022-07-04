package com.example.spring_crud.controller;

import com.example.spring_crud.configuration.TokenManager;
import com.example.spring_crud.mapper.UserDTO;
import com.example.spring_crud.mapper.UserMapper;
import com.example.spring_crud.model.JwtRequestModel;
import com.example.spring_crud.model.JwtResponseModel;
import com.example.spring_crud.model.User;
import com.example.spring_crud.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@CrossOrigin
@RestController("UserController")
@RequestMapping("/user")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @GetMapping("findUserById/{userId}")
    public UserDTO findUserById(@PathVariable("userId") long userId) {
        User userData = userService.findById(userId);
        return UserMapper.toUserDTO(userData);
    }

    @DeleteMapping("deleteUserbyId/{userId}")
    public void deleteUserByid(@PathVariable("userId") long userId) {
        userService.deleteById(userId);
    }
}
