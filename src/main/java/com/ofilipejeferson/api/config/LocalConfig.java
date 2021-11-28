package com.ofilipejeferson.api.config;

import com.ofilipejeferson.api.domain.User;
import com.ofilipejeferson.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    private UserRepository userRepository;
    
    @Bean
        public void startDB(){
        User user1 =  new User(1, "Filipe Jeferson", "filipe@email.com","teste123");
        User user2 =  new User(2, "Luana Cabral", "luana@email.com","teste123");

        userRepository.saveAll(List.of(user1, user2));
    }
}
