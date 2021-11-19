package com.football.betting.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.football.betting.models.BetTransactionStatus;
import com.football.betting.models.Match;
import com.football.betting.models.Result;
import com.football.betting.service.MatchService;
@Controller
public class MatchController {
	
	@Resource
	private MatchService matchService;

	@PostMapping("/match")
	public ResponseEntity<String> saveMatch(@RequestBody Match match) {
		
		Match match1= matchService.findMatchById(match.getMatchId());
		if(match1==null) {		
			match.setBetTransactionStatus(BetTransactionStatus.UNPROCESSED);
			match.setResult(Result.YET_TO_START);
			matchService.save(match);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		
	}
	
	@PutMapping("/match")
	public ResponseEntity<String> updateMatch(@RequestBody Match match) {
		Match match1= matchService.findMatchById(match.getMatchId());
		if(match1==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		matchService.save(match);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/match/{id}")
	public Match getMatch(@PathVariable int id) {
		return matchService.findMatchById(id);
		
	}

}
