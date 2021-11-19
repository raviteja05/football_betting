package com.football.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.betting.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	User findByUserName(String userName);

}
