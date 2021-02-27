package com.example.spring_crud.mapper;

import com.example.spring_crud.model.Address;

import java.util.*;
import java.util.stream.Collectors;

public class AddressMapper {

    public static Address toAddress(AddressDTO addressDTO){
        if (addressDTO == null) {
            return null;
        }
        return Address.builder()
                .address1(addressDTO.getAddress1())
                .address2(addressDTO.getAddress2())
                .address3(addressDTO.getAddress3())
                .city(addressDTO.getCity())
                .country(addressDTO.getCountry())
                .userAccount(UserMapper.toUser(addressDTO.getUserAccount()))
                .acctId(addressDTO.getAcctId())
                .build();
    }

    public static AddressDTO toAddressDTO(Address address){
        if (address == null) {
            return null;
        }
        return AddressDTO.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .address3(address.getAddress3())
                .city(address.getCity())
                .country(address.getCountry())
                .userAccount(UserMapper.toUserDTO(address.getUserAccount()))
                .acctId(address.getAcctId())
                .build();
    }

    public static Address toUpdateAddress(Address address, Address updateAddress){

        address.setAcctId(updateAddress.getAcctId() == null ? address.getAcctId() : updateAddress.getAcctId());
        address.setAddress1(updateAddress.getAddress1() == null ? address.getAddress1() : updateAddress.getAddress1());
        address.setAddress2(updateAddress.getAddress2() == null ? address.getAddress2() : updateAddress.getAddress2());
        address.setAddress3(updateAddress.getAddress3() == null ? address.getAddress3() : updateAddress.getAddress3());
        address.setCity(updateAddress.getCity() == null ? address.getCity() : updateAddress.getCity());
        address.setCountry(updateAddress.getCountry() == null ? address.getCountry() : updateAddress.getCountry());

        return address;
    }

    public static List<Address> toAddresses(List<AddressDTO> addressDTOS){
        return addressDTOS.stream().map(a ->  toAddress(a)).collect(Collectors.toList());
    }

    public static List<AddressDTO> toAddressDTOs(List<Address> addresses){
        return addresses.stream().map(a ->  toAddressDTO(a)).collect(Collectors.toList());
    }
}
