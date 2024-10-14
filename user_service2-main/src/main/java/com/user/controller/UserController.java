package com.user.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.entity.User;
import com.user.exception.ResourcesNotFoundException;
import com.user.response.FileUploadResponse;
import com.user.service.UserService;
import com.user.util.FileUploadUtil;

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

	@PostMapping(value = "/saveUser")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);

	}
	
	@GetMapping(value="/getUsertdetailbyUserId/{id}")
	public User getUsertdetailbyUserId(@PathVariable("id") Integer id) {
		
		if(id!=null) {
		return userService.getUserbyId(id);
		}else {
			
			//System.out.println(id + " Is Not Found .. Please try another Id");
			throw new ResourcesNotFoundException("name","phone", id);
		}
	}
	
	
	@GetMapping("/getUserInfobyId/{id}")
	public ResponseEntity<User> getUserDetailbyId( @PathVariable("id") Integer id){
		
		return new ResponseEntity<>(userService.getUserbyId(id), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getAllUser")
	public List<User> getAllUser() {
		
		return userService.getAllUser();
	}
	
	
	@PutMapping("{/id}")
	public  ResponseEntity<User> updateUser(Integer id, User user) {
		         User u =userService.updateUser(id, user);
		         return ResponseEntity.ok(u);
	}
	
	/*
	 * @GetMapping("/user/userdetailsByUerId/{userId}") public List<User>
	 * findUserDetailsByUerId(@PathVariable("userId") Integer userId){
	 * 
	 * return userService.findUserDetailsByUerId(userId); }
	 */

	 @PostMapping("/uploadFile")
	    public ResponseEntity<FileUploadResponse> uploadFile(
	            @RequestParam("file") MultipartFile multipartFile)
	                    throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        long size = multipartFile.getSize();
	         
	        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
	         
	        FileUploadResponse response = new FileUploadResponse();
	        response.setFileName(fileName);
	        response.setSize(size);
	        response.setDownloadUri("/downloadFile/" + filecode);
	         
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	 
	 
	 @DeleteMapping("user/userDeleteById/{userId}")
	 public ResponseEntity<User> userDeleteById(@PathVariable("userId") Integer userId){
		 
		 userService.deleteUser(userId);
		 
		 return  ResponseEntity.noContent().build();
		 
	 }
	 
}
