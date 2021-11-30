package com.ofilipejeferson.api.service;

import com.ofilipejeferson.api.domain.User;
import com.ofilipejeferson.api.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDto obj);
    User update(UserDto obj);
}
