package com.football.betting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.betting.models.Bet;
import com.football.betting.models.Match;
import com.football.betting.models.User;

@Repository
public interface BetRepository extends JpaRepository<Bet, Integer> {
	
	Bet findByUserAndMatch(User user,Match match);
	
	List<Bet> findByMatch(Match match);
}
