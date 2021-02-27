package com.example.spring_crud.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    private Long id;
    private UserDTO userAccount;
    private Long acctId;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String country;
}
