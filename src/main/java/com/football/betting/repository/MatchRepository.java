package com.football.betting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.football.betting.models.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>{
	
	@Query(value = "select * from football_match where bet_transaction_status=0 and (result=0 or result=1 or result=2)",nativeQuery = true)
	List<Match> findAllPlayedMatches();
	
	@Query(value = "select * from football_match where result=3 or result=4",nativeQuery = true)
	List<Match> findAllUnplayedMatches();

}
