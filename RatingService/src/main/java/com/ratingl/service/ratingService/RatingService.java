package com.ratingl.service.ratingService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ratingl.service.model.Rating;


public interface RatingService {

	//create
	public Rating create(Rating rating);
	
	
	//get all by user id
	public List<Rating> getByUser(String userId);
	
	//get all by hotel id
	public List<Rating> getByHotel(String hotelId);

	
	
	//getAll
	public List<Rating>getAll();


}
