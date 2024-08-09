package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {

	
	public User getUserbyId(Integer id);
	
	User addUser(User user);
	
	
	List<User> getAllUser();
}
