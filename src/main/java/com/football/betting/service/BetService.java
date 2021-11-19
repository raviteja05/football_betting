package com.football.betting.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.football.betting.models.Bet;
import com.football.betting.models.Match;
import com.football.betting.models.Result;
import com.football.betting.models.Team;
import com.football.betting.models.User;
import com.football.betting.repository.BetRepository;

@Service
public class BetService {

	@Resource
	private BetRepository betRepository;
	
	@Resource
	private UserService userService;
	
	@Resource
	private MatchService matchService;
	
	@Resource
	private TeamService teamService;
	
	@Resource
	private Environment env;
	 
	public boolean save(Bet bet) {
		User user=userService.getUserByUserName(bet.getUser().getUserName());
		Match match=matchService.findMatchById(bet.getMatch().getMatchId());
		Team team=teamService.getTeamById(bet.getTeam().getId());
		Bet bet1=betRepository.findByUserAndMatch(user, match);
		bet.setTeam(team);
		bet.setMatch(match);
		bet.setUser(user);
		bet.setRate(Integer.valueOf(env.getProperty("bet.rate")));
		if(match.getResult().equals(Result.YET_TO_START)&&null==bet1) {
			betRepository.save(bet);
		}else {
			return false;
		}

		return true;

	}

	public List<Bet> getAll() {

		return betRepository.findAll();

	}
	
	public List<Bet> getAllBetsByMatch(Match match) {

		return betRepository.findByMatch(match);

	}

	public Optional<Bet> getById(int id) {

		return betRepository.findById(id);

	}

}
