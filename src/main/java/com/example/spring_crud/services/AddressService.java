package com.example.spring_crud.services;

import com.example.spring_crud.model.Address;
import com.example.spring_crud.model.User;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address saveOrUpdate (Address user);

    Optional<Address> findById(Long id);

    void deleteById(Long id);

    List<Address> findByUserAccount(Long userId);
}
