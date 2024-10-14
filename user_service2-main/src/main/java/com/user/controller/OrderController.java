package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.OrderRequest;
import com.user.entity.User;
import com.user.repository.ProductRepository;
import com.user.repository.UserRepository;

@RestController
public class OrderController {

	
	@Autowired
	private UserRepository userRepository;
	
	
	//@Autowired
	//private ProductRepository productRepository;
	
	@PostMapping("/placeOrder")
	public User placeOrder(@RequestBody OrderRequest request) {
		
		return userRepository.save(request.getUser());
	}
	
	@GetMapping("/findAllOrders")
	public List<User> findAllOrders(){
		
		return userRepository.findAll();
		
	}
}

