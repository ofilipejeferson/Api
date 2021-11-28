package com.ofilipejeferson.api.service.impl;

import com.ofilipejeferson.api.domain.User;
import com.ofilipejeferson.api.repositories.UserRepository;
import com.ofilipejeferson.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElse(null);
    }
}
