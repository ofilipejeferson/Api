package com.ofilipejeferson.api.controller;

import com.ofilipejeferson.api.domain.User;
import com.ofilipejeferson.api.domain.dto.UserDto;
import com.ofilipejeferson.api.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto obj){
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(userService.create(obj).getId()).toUri()).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto obj){
        obj.setId(id);
        User newObj = userService.update(obj);
        return ResponseEntity.ok().body(mapper.map(newObj, UserDto.class));
    }
}
