package com.user.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class UserController {
	
	@GetMapping("/getuser")
	public String getDetails(Principal principal) {
		
		return "Hi "+principal.getName()+" How are you ";
		
	}
	
	@GetMapping("/getuserDetails")
	public String getDetails() {
		return "Hi  How are you ";
		
	}
	
}
