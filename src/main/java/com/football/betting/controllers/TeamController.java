package com.football.betting.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.football.betting.models.Team;
import com.football.betting.service.TeamService;

@Controller
public class TeamController {
	
	@Resource
	private TeamService teamService;

	@PostMapping("/team")
	public ResponseEntity<String> saveTeam(@RequestBody Team team) {
		
		Team team1= teamService.getTeamById(team.getId());
		if(team1==null) {
			team.setName(team.getName().toLowerCase());
			teamService.save(team);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		
	}
	
	@GetMapping("/team/{id}")
	public ResponseEntity<Team> getTeam(@PathVariable int id) {
		return new ResponseEntity<Team>(teamService.getTeamById(id), HttpStatus.OK);
		
	}

}
