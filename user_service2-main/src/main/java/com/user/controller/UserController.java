package com.user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@Scope(value = "request")
public class UserController {

	@Autowired
	// @Qualifier(value="userService")
	UserService userService;

	@GetMapping("/getuser")
	public String getDetails(Principal principal) {

		return "Hi " + principal.getName() + " How are you ";

	}

	@GetMapping("/getuserDetails")
	public String getDetails() {
		return "Hi  How are you ";

	}

	@PostMapping(value = "/saveUser", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);

	}
	
	@GetMapping(value="/getUsertdetailbyUserId/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getUsertdetailbyUserId(@PathVariable("id") Integer id) {
		
		if(id!=null) {
		return userService.getUserbyId(id);
		}else {
			
			System.out.println(id + " Is Not Found .. Please try another Id");
		}
		return null;
	}
	
	@GetMapping(value="/getAllUser", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getAllUser() {
		
		return userService.getAllUser();
	}
}
