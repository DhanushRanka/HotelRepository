package com.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.user.service.external.services.RatingService;
import com.user.service.model.Rating;

@SpringBootTest
@Component
class UserServiceApplicationTests {

	@Autowired
	RatingService ratingService;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void createRating()
	{
		Rating rating=new Rating("100","1000","10000",1000000,"iam testting it");
		Rating rate = ratingService.createRating(rating);
		
		System.out.println("Rating "+ rate);
	}

}
