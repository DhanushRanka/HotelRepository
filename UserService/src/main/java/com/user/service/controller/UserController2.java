package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.model.User;
import com.user.service.repo.UserRepository;
import com.user.service.userService.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController2 {

	@Autowired
	UserService userService;
	
	//create
	@PostMapping("/create")
	public User create(@RequestBody User user)
	{
		int []a= {4};
		int n=0;
		
		userService.save(user);
		return user;
	}
	
	int retryCount=1;
	
	
	//single user
	@GetMapping("/{userId}")
	//@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
	//@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallBack")
	@RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallBack")
	public User getSingle(@PathVariable("userId")String id)
	{
		System.out.println("retry count is "+retryCount);
		User user = userService.getUser(id);
		return user;
	}
	
	//creating fallback method
	
	
	public User ratingHotelFallBack(String id,Exception ex)
	{
		ex.printStackTrace();
		
		System.out.println("Fallback method is executed "+ex.getMessage());
		
		
		User user=new User();
		user.setEmail("dummygmail");
		user.setName("name");
		
		return user;
	}
	
	
	//all user
	@GetMapping("all")
	public List<User> getAllUser()
	{
		List<User> users = userService.getAllUser();
		return users;
	}
	
}
