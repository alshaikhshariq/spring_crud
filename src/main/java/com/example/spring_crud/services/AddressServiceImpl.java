package com.example.spring_crud.services;

import com.example.spring_crud.mapper.AddressMapper;
import com.example.spring_crud.model.Address;
import com.example.spring_crud.model.User;
import com.example.spring_crud.repository.AddressRepository;
import com.example.spring_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Override
    public Address saveOrUpdate(Address address) {
        if(address.getId() != null){
            Address addressData = addressRepository.getOne(address.getId());
            if(addressData == null){

            }
            addressData = AddressMapper.toUpdateAddress(addressData, address);
            if(address.getAcctId() != null){
                User user = userService.findById(address.getAcctId());
                address.setUserAccount(user);
            }
            return addressRepository.save(addressData);
        }
        if (address.getAcctId() != null){
            User user = userService.findById(address.getAcctId());
            address.setUserAccount(user);
        }
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findByUserAccount(Long userId) {
        User user = userService.findById(userId);
        return addressRepository.findByUserAccount(user);
    }
}
