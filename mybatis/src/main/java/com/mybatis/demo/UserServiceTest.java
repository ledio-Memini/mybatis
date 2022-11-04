package com.mybatis.demo;

import java.util.List;


import com.mybatis.demo.domain.User;
import com.mybatis.demo.service.UserService;


public class UserServiceTest {

	private static UserService userService;


	public void testGetUserById()
	{
		User user = userService.getUserById(1);

		System.out.println(user);
	}

	
	public void testGetAllUsers()
	{
		List<User> users = userService.getAllUsers();

		for (User user : users)
		{
			System.out.println(user);
		}
	}

	
	public void testInsertUser()
	{
		User user = new User();
		user.setEmailId("test_email_" + System.currentTimeMillis() + "@gmail.com");
		user.setPassword("secret");
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");

		userService.insertUser(user);

	}

	
	public void testUpdateUser()
	{
		long timestamp = System.currentTimeMillis();
		User user = userService.getUserById(2);
		user.setFirstName("TestFirstName" + timestamp);
		user.setLastName("TestLastName" + timestamp);
		userService.updateUser(user);


	}

	
	public void testDeleteUser()
	{
		User user = userService.getUserById(4);
		userService.deleteUser(user.getUserId());


	}
}
