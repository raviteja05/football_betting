package com.football.betting.controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.football.betting.models.Bet;
import com.football.betting.models.Match;
import com.football.betting.models.Result;
import com.football.betting.service.BetService;
import com.football.betting.service.MatchService;

@RestController
public class BettingController {
	@Resource
	private BetService betService;

	@Resource
	private MatchService matchService;

	@PostMapping("/bet")
	public ResponseEntity<String> saveBets(@RequestBody Bet bet) {
		Match match = matchService.findMatchById(bet.getMatch().getMatchId());
		if (isBetValid(bet, match)) {
			boolean status = betService.save(bet);
			if (status) {
				return new ResponseEntity<String>(HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<String>(HttpStatus.CONFLICT);

	}

	private boolean isBetValid(Bet bet, Match match) {
		return match.getResult().equals(Result.YET_TO_START) && ((bet.getTeam().getId() == match.getTeam1().getId())
				|| (bet.getTeam().getId() == match.getTeam2().getId()));
	}

	@GetMapping("/bet")
	public ResponseEntity<List<Bet>> getBets() {

		return new ResponseEntity<List<Bet>>(betService.getAll(), HttpStatus.OK);

	}

	@GetMapping("/bet/{id}")
	public ResponseEntity<Bet> getBetByID(@PathVariable Integer id) {

		Optional<Bet> bet = betService.getById(id);
		if (!bet.isPresent())
			return new ResponseEntity<Bet>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Bet>(bet.get(), HttpStatus.OK);

	}

}
