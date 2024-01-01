package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.service.model.Rating;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService {

	
	@PostMapping("/rating/create")
	Rating createRating(Rating rating);
	
}
