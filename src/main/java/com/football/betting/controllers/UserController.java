package com.football.betting.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.betting.models.User;
import com.football.betting.service.UserService;

@RestController
@Validated
public class UserController {
	@Resource
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@Valid @RequestBody User user) {
		
		User user1= userService.getUserByUserName(user.getUserName().toLowerCase());
		if(user1==null) {
			user.setUserName(user.getUserName().toLowerCase());
			userService.save(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		
	}
	
	@GetMapping("/user/{userName}")
	public User getUser(@PathVariable String userName) {
		return userService.getUserByUserName(userName);
		
	}
}
