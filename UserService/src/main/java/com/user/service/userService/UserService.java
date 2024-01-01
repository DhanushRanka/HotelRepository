package com.user.service.userService;

import java.util.List;

import com.user.service.model.User;

public interface UserService {
	
	
	//create a user
	User save(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get single user
	
	User getUser(String userId);

}
