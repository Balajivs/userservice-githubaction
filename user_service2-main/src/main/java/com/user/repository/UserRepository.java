package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository(value="userRepository")
//@Scope(value="singleton")
public interface UserRepository extends JpaRepository<User, Integer>{


	//@Procedure("GetUsertdetailsbyUserId")
	//List<User>  findUserDetailsByUerId(@Param("userId") Integer userId);
	
	
	//List<User>  findUserDetailsByUerId(@Param("userId") Integer userId);
	
	
	
}
