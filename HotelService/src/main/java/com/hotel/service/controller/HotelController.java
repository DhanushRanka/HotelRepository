package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.HotelService.HotelService;
import com.hotel.service.model.Hotel;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	//create
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/create")
	public Hotel create(@RequestBody Hotel hotel)
	{
		return hotelService.create(hotel);
	}
	
	
	//get all
	@PreAuthorize("hasAuthority('SCOPE_internal')|| hasAuthority('Admin')")
	@GetMapping("/getAll")
	public List<Hotel> getAll()
	{
		return hotelService.getAll();
	}
	
	
	//get
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{id}")
	public Hotel get(@PathVariable("id")String id)
	{
		return hotelService.get(id);
	}
	
}
