package com.example.spring_crud.controller;

import com.example.spring_crud.mapper.AddressDTO;
import com.example.spring_crud.mapper.AddressMapper;
import com.example.spring_crud.model.Address;
import com.example.spring_crud.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("addAddress")
    public AddressDTO addAddress(@RequestBody AddressDTO addressDTO){
        return AddressMapper.toAddressDTO(addressService.saveOrUpdate(AddressMapper.toAddress(addressDTO)));
    }

    @GetMapping("findByUserId/{userId}")
    public List<AddressDTO> findByUserId(@PathVariable("userId") long userId){
        return AddressMapper.toAddressDTOs(addressService.findByUserAccount(userId));
    }

    @DeleteMapping("deleteByUserId/{userId}")
    public void deleteByUserId(@PathVariable("userId") long userId){
        addressService.deleteById(userId);
    }
}
