package com.ratingl.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratingl.service.model.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String>{

	//custon finder method
	List<Rating>findByUserId(String userId);
	
	List<Rating>findByHotelId(String hotelId);
}
