package com.football.betting.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "football_match")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchId;

	@OneToOne
	private Team team1;

	@OneToOne
	private Team team2;

	private Result result;

	private BetTransactionStatus betTransactionStatus;

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public BetTransactionStatus getBetTransactionStatus() {
		return betTransactionStatus;
	}

	public void setBetTransactionStatus(BetTransactionStatus betTransactionStatus) {
		this.betTransactionStatus = betTransactionStatus;
	}

}
