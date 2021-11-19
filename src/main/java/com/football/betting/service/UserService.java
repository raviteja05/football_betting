package com.football.betting.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.football.betting.models.User;
import com.football.betting.repository.UserRepository;

@Service
public class UserService {
	
	@Resource
	private UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllTeams(){
		return userRepository.findAll();
	}
	
	public User getUserByUserName(String userName){
		return userRepository.findByUserName(userName);
	}


}
