package com.ofilipejeferson.api.service;

import com.ofilipejeferson.api.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
