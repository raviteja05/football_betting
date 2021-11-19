package com.football.betting.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.football.betting.models.Bet;
import com.football.betting.models.BetStatus;
import com.football.betting.models.BetTransaction;
import com.football.betting.models.BetTransactionStatus;
import com.football.betting.models.Match;
import com.football.betting.models.Result;
import com.football.betting.models.Team;
import com.football.betting.repository.BetTransactionRepository;

@Service
public class BetTransactionService {

	@Resource
	private BetTransactionRepository betTransactionRepository;

	@Resource
	private BetService betService;

	@Resource
	private MatchService matchService;

	public boolean save(BetTransaction betTransaction) {

		betTransactionRepository.save(betTransaction);
		return true;
	}

	public boolean processBetTransaction() {

		List<Match> playedMatches = matchService.getAllPlayedMatches();

		for (Match match : playedMatches) {

			processBetsForMatch(match);
			match.setBetTransactionStatus(BetTransactionStatus.PROCESSED);
			matchService.save(match);
		}

		return true;

	}

	private void processBetsForMatch(Match match) {
		Team winningTeam = null;
		if (!match.getResult().equals(Result.DRAW))
			winningTeam = match.getResult().equals(Result.TEAM_1_WIN) ? match.getTeam1() : match.getTeam2();
		List<Bet> bets = betService.getAllBetsByMatch(match);
		for (Bet bet : bets) {
			BetTransaction betTransaction = new BetTransaction();
			if (winningTeam != null && bet.getTeam().getId() == winningTeam.getId()) {
				processBet(bet.getAmount() + bet.getAmount() * bet.getRate(), BetStatus.CREDIT, betTransaction, bet);
			} else if (winningTeam == null) {
				processBet(bet.getAmount() / 2, BetStatus.DEBIT, betTransaction, bet);
			} else {
				processBet(bet.getAmount(), BetStatus.DEBIT, betTransaction, bet);
			}

		}
	}

	private void processBet(double amount, BetStatus status, BetTransaction betTransaction, Bet bet) {
		betTransaction.setAmount(amount);
		betTransaction.setBetStatus(status);
		betTransaction.setBet(bet);
		betTransaction.setBetTransactionStatus(BetTransactionStatus.UNPROCESSED);
		betTransactionRepository.save(betTransaction);

	}

}
