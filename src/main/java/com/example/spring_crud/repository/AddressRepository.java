package com.example.spring_crud.repository;

import com.example.spring_crud.model.Address;
import com.example.spring_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserAccount(User userAccount);

}
