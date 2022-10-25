package com.progetto.springboot.controller;

import java.util.HashMap;
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
import com.progetto.springboot.exception.UserIdAlreadyExistException;
import com.progetto.springboot.exception.UserIdNotFoundException;
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
        return userRepository.findAll();
    }

    // create user rest API
    @PostMapping("/persona")
    public User createUser(@RequestBody User user)  {
        if(userRepository.findById(user.getId())==null) {
            int id = userRepository.insert(user);
            return userRepository.findById(user.getId());
        }else
        {
            throw new UserIdAlreadyExistException();
        }

    }

    // get user by id rest api
    @GetMapping("/persona/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id);
        if(user==null)
        {
            throw new UserIdNotFoundException();
        }
        return ResponseEntity.ok(user);
    }

 // update user rest api
 @PutMapping("/persona/{id}")
 public ResponseEntity<User> updateUser(@PathVariable Long id,
             @RequestBody User userDetails) {
  if(userRepository.update(new User(id, userDetails.getFirstName(), 
         userDetails.getLastName(), userDetails.getEmailId()))==0)
            {
                throw new UserIdNotFoundException();
            }

       return ResponseEntity.ok(userRepository.findById(id));
    }

    // delete user rest api
    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser
               (@PathVariable Long id) {
        userRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}