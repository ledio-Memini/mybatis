package com.progetto.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progetto.springboot.entity.User;
import com.progetto.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // get all users
    @GetMapping("/persona")
    public List<User> getAllUsers()
    {
        return userRepository.getAllUsers();
    }


    @PostMapping("/persona")
    public User createUser(@RequestBody User user)  {
        return userRepository.getUserById((int) user.getId()); 
    }

    @GetMapping("/persona/{id}")
    public void getUserById(@PathVariable long id) {
        User user = userRepository.getUserById((int) id);
    }


	 @PutMapping("/persona/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails) {
			return userRepository.updateUser(userDetails.getFirstName(),userDetails.getLastName());
			    }


    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        return userRepository.deleteById(id);

    }
}