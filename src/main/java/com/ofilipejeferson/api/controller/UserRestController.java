package com.ofilipejeferson.api.controller;

import com.ofilipejeferson.api.domain.User;
import com.ofilipejeferson.api.domain.dto.UserDto;
import com.ofilipejeferson.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDto.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(){
        return ResponseEntity.ok()
                        .body(userService.findAll().stream().map(x -> mapper.map(x, UserDto.class)).collect(Collectors.toList()));
    }
}
