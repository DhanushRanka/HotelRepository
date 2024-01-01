package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.user.service.external.services.RatingService;
import com.user.service.model.Rating;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		
	}

}
