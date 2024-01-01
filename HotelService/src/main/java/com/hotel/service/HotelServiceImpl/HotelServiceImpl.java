package com.hotel.service.HotelServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.HotelService.HotelService;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.model.Hotel;
import com.hotel.service.reporitory.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	HotelRepository hotelRepo;
	
	
	@Override
	public Hotel create(Hotel hotel) {
		
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel get(String hotelId) {
		Hotel hotel=null;
		try {
			hotel = hotelRepo.findById(hotelId)
											.orElseThrow(()->new ResourceNotFoundException("hotel withgiven id not found"));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return hotel;
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepo.findAll();
	}
	
	
	
	

}
