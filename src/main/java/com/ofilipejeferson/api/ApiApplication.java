package com.ofilipejeferson.api;

import com.ofilipejeferson.api.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder Application){
		return Application.sources(ApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
