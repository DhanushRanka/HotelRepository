package com.user.service.userService.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.user.service.exception.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.external.services.RatingService;
import com.user.service.model.Hotel;
import com.user.service.model.Rating;
import com.user.service.model.User;
import com.user.service.repo.UserRepository;
import com.user.service.userService.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	RatingService ratingService;
	
//	@Autowired
//	Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User save(User user) {
		userRepo.save(user);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User getUser(String userId) {
		User user=null;
		
//		Rating rating1=new Rating("100","1","1",3,"this is nice hotel");
//		Rating rate = ratingService.createRating(rating1);
//		
//		System.out.println("Rating "+ rate);
		
		
		try {
			user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id does not exist"));
		
			Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+user.getUserId(), Rating[].class);
			
			List<Rating> ratingOfUser = Arrays.stream(ratings).toList();
			
			List<Rating> ratingList = ratingOfUser.stream().map((rating)->{
				//call hotel service to get rating for a particular hotel
				//set hotel to rating
				//return the rating
				//url  http://localhost:8081/hotels/1
				//ResponseEntity<Hotel> ratingOfHotel = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
				
				Hotel hotel=hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				
				return rating;
			}).collect(Collectors.toList());
			
			user.setRating(ratingList);
			System.out.println(ratingOfUser.toString());
			//			logger.info("", li);
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

}
