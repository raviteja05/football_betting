package com.football.betting.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.football.betting.models.Match;
import com.football.betting.repository.MatchRepository;

@Service
public class MatchService {
	
	@Resource
	private MatchRepository matchRepository;
	
	
	public boolean save(Match match) {
		matchRepository.save(match);
		return true;
	}
	
	public List<Match> getAllMatches(){
		List<Match> matches=matchRepository.findAll();
		return matches;
	}
	
	public List<Match> getAllPlayedMatches(){
		List<Match> matches=matchRepository.findAllPlayedMatches();
		
		
		return matches;
	}
	
	public Match findMatchById(int id){
		
		return matchRepository.findById(id).isPresent()?matchRepository.findById(id).get():null;
	}

}
