package com.example.spring_crud.mapper;

import com.example.spring_crud.model.User;

public class UserMapper {

    public static User toUser(UserDTO userDTO){
        if(userDTO == null){
            return null;
        }

        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .jobTitle(userDTO.getJobTitle())
                .build();
    }

    public static UserDTO toUserDTO(User user){
        if(user == null){
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .jobTitle(user.getJobTitle())
                .build();
    }

    public static User toUpdateUser(User user, User updateUser){
        user.setJobTitle(updateUser.getJobTitle() == null ? user.getJobTitle() : updateUser.getJobTitle());
        user.setLastName(updateUser.getLastName() == null ? user.getLastName() : updateUser.getLastName());
        user.setFirstName(updateUser.getFirstName() == null ? user.getFirstName() : updateUser.getFirstName());
        return user;
    }
}
