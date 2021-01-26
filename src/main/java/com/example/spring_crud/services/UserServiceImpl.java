package com.example.spring_crud.services;

import com.example.spring_crud.model.User;
import com.example.spring_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveOrUpdate(User user) {
        if (user.getId() != null){
            User userData = userRepository.getOne(user.getId());
            if (userData == null){
                return null;
            }
            userData.setFirstName(user.getFirstName());
            userData.setLastName(user.getLastName());
            userData.setJobTitle(user.getJobTitle());
            return userRepository.save(userData);
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
