package com.hotel.service.HotelService;

import java.util.List;

import com.hotel.service.model.Hotel;

public interface HotelService {
	
	//create
	
	Hotel create(Hotel hotel);
	
	
	//get
	
	Hotel get(String hotelId);
	
	
	//getAll
	List<Hotel>getAll();

}
