package com.example.spring_crud.mapper;

import com.example.spring_crud.model.Address;
import com.example.spring_crud.model.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String firstName;
    private String username;
    private String lastName;
    private String jobTitle;
    private String password;
    private List<AddressDTO> addresses;
    private Set<String> roles;
}
