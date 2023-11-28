package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService{

	
	List<User> list = List.of(
			new User(1313L,"rama","99887766"),
			new User(1314L,"seeta","99887766"),
			new User(1315L,"laxman","99887766")	);
	
	
	
	@Override
	public User getUser(Long id) {
		
		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
		
	}

	
	
}
