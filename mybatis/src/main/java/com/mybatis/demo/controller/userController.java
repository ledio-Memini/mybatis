package com.mybatis.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mybatis.demo.domain.User;
import com.mybatis.demo.service.UserService;


@Controller
public class userController {

	
	@Autowired
	private UserService userService;

	   @GetMapping("/user")
	    public List<User> getAllUsers()
	    {
	        return userService.getAllUsers();
	    }
	   

	    @PostMapping("/persona")
	    public User createUser(@RequestBody User user)  {
	        return userService.getUserById((int) user.getUserId()); 
	    }

	    @GetMapping("/persona/{id}")
	    public void getUserById(@PathVariable long id) {
	        User user = userService.getUserById((int) id);
	    }


		 @PutMapping("/persona/{id}")
		 public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails) {
				return userService.updateUser(userDetails.getFirstName(),userDetails.getLastName());
				    }


	    @DeleteMapping("/persona/{id}")
	    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable long id) {
	        return userService.deleteUser(id);
	        
	    }

	   
}
