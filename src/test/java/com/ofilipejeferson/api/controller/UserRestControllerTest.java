package com.ofilipejeferson.api.controller;

import com.ofilipejeferson.api.domain.User;
import com.ofilipejeferson.api.domain.dto.UserDto;
import com.ofilipejeferson.api.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRestControllerTest {

    public static final Integer ID      = 1;
    public static final String NAME     = "Filipe";
    public static final String EMAIL    = "filipe@outlook.com";
    public static final String PASSWORD = "teste123";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado!";
    public static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA = "E-mail já cadastrado no sistema!";

    @InjectMocks
    private UserRestController userRestController;
    @Mock
    private ModelMapper mapper;
    @Mock
    private UserService userService;
    private User user;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDto(ID, NAME, EMAIL, PASSWORD);
    }
}