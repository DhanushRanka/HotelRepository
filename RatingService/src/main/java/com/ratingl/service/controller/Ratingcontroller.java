package com.ratingl.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingl.service.model.Rating;
import com.ratingl.service.ratingService.RatingService;

@RestController
@RequestMapping("/rating")
public class Ratingcontroller {

	@Autowired
	RatingService ratingservice;
	
	
	@PostMapping("/create")
	public Rating create(@RequestBody Rating rating)
	{
		return ratingservice.create(rating);
	}
	
	@GetMapping("user/{userId}")
	public List<Rating> getByUserId(@PathVariable String userId)
	{
		return ratingservice.getByUser(userId);
	}
	
	@GetMapping("hotels/{hotelId}")
	public List<Rating> getByHotelId(@PathVariable String hotelId)
	{
		return ratingservice.getByHotel(hotelId);
	}
	
	@GetMapping("/getAll")
	public List<Rating> getAll()
	{
		return ratingservice.getAll();
	}
}
