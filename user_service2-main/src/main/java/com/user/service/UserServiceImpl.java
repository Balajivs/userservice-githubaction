package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier(value = "userRepository")
	UserRepository userRepository;

	/*
	 * @Override public User getUser(Long id) {
	 * 
	 * return list.stream().filter(user ->
	 * user.getUserId().equals(id)).findAny().orElse(null);
	 * 
	 * }
	 */

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserbyId(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	

}
