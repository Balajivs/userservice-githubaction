package com.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.entity.User;
import com.user.exception.ResourcesNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	

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

		
		logger.info("User add {}");
		
		
		return userRepository.save(user);
	}

	@Override
	@Cacheable(cacheNames = "user", key="#id")
	public User getUserbyId(Integer id) {
		// TODO Auto-generated method stub
		
		logger.info("Getting  USer  from DB {}");
		
	    Optional<User> user  =   userRepository.findById(id);
	    
	    if(user.isPresent()) {
	    	
	    	return user.get();
	    }else {
	    	
	    	throw new ResourcesNotFoundException("User", "Id",id);
	    	
	    }
	    
	    
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	
	@Override
	@CachePut(cacheNames = "user", key="#user.id")
	public User updateUser(Integer id, User user) {
		// TODO Auto-generated method stub

		Optional<User> u = userRepository.findById(id);

		logger.info("User Update {} ");
		if (u.isPresent()) {

			User user1 = u.get();

			user1.setName(user.getName());
			user1.setPhone(user.getPhone());
			user1.setProducts(user.getProducts());

			return userRepository.save(user1);

		} else {

			throw new RuntimeException("User Not Found");
		}

	}

	@Override
	@CacheEvict(cacheNames = "user", key="#id")
	public String deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(id);
		
		return "User has been deleted";
	}

	

	

}
