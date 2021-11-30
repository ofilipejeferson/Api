package com.ofilipejeferson.api.service.impl;

import com.ofilipejeferson.api.domain.User;
import com.ofilipejeferson.api.domain.dto.UserDto;
import com.ofilipejeferson.api.repositories.UserRepository;
import com.ofilipejeferson.api.service.UserService;
import com.ofilipejeferson.api.service.exceptions.DataIntegratyViolationException;
import com.ofilipejeferson.api.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User create(UserDto obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDto obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDto obj){
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
