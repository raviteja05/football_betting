package com.football.betting.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.football.betting.models.Team;
import com.football.betting.repository.TeamRepository;

@Service
public class TeamService {
	
	@Resource
	private TeamRepository teamRepository;
	
	public void save(Team team) {
		teamRepository.save(team);
	}
	
	public List<Team> getAllTeams(){
		return teamRepository.findAll();
	}

	public Team getTeamById(int id) {
		// TODO Auto-generated method stub
		return teamRepository.findById(id).isPresent()?teamRepository.findById(id).get():null;
	}

}
