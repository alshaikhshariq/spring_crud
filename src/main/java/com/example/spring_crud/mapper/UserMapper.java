package com.example.spring_crud.mapper;

import com.example.spring_crud.model.Role;
import com.example.spring_crud.model.User;

import java.util.stream.Collectors;

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
                .password(userDTO.getPassword())
                .username(userDTO.getUsername())
                .addresses(AddressMapper.toAddresses(userDTO.getAddresses()))
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
                .password(user.getPassword())
                .username(user.getUsername())
                .jobTitle(user.getJobTitle())
                .roles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()))
                .addresses(AddressMapper.toAddressDTOs(user.getAddresses()))
                .build();
    }

    public static User toUpdateUser(User user, User updateUser){
        user.setJobTitle(updateUser.getJobTitle() == null ? user.getJobTitle() : updateUser.getJobTitle());
        user.setLastName(updateUser.getLastName() == null ? user.getLastName() : updateUser.getLastName());
        user.setFirstName(updateUser.getFirstName() == null ? user.getFirstName() : updateUser.getFirstName());
        return user;
    }
}
