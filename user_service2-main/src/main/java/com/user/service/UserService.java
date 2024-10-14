package com.user.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.user.entity.User;

public interface UserService {

	
	public User getUserbyId(Integer id);
	
	User addUser(User user);
	
	
	List<User> getAllUser();
	
	//List<User>  findUserDetailsByUerId(Integer id);
	
	User updateUser(Integer id,User user);
	
	public String deleteUser(Integer id);
}
