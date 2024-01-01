package com.ratingl.service.ratingServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingl.service.exception.ResourceNotFoundException;
import com.ratingl.service.model.Rating;
import com.ratingl.service.ratingService.RatingService;
import com.ratingl.service.repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepo ratingRepo;
	
	
	@Override
	public Rating create(Rating rating) {
		Rating rate = ratingRepo.save(rating);
		return rate;
	}

	@Override
	public List<Rating> getAll() {
		List<Rating> ratings = ratingRepo.findAll();
		return ratings;
	}


	@Override
	public List<Rating> getByUser(String userId) {
		return ratingRepo.findByUserId(userId);
	}


	@Override
	public List<Rating> getByHotel(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}
	
}
