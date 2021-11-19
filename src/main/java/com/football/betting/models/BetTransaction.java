package com.football.betting.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BetTransaction {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int betTransactionId;
	
	@OneToOne
	private Bet bet;
	private double amountToBePaid;
	private BetStatus betStatus;
	private BetTransactionStatus betTransactionStatus;
	public Bet getBet() {
		return bet;
	}
	public void setBet(Bet bet) {
		this.bet = bet;
	}
	public BetStatus getBetStatus() {
		return betStatus;
	}
	public void setBetStatus(BetStatus betStatus) {
		this.betStatus = betStatus;
	}
	public int getBetTransactionId() {
		return betTransactionId;
	}
	public void setBetTransactionId(int betTransactionId) {
		this.betTransactionId = betTransactionId;
	}
	public double getAmount() {
		return amountToBePaid;
	}
	public void setAmount(double amount) {
		this.amountToBePaid = amount;
	}
	public double getAmountToBePaid() {
		return amountToBePaid;
	}
	public void setAmountToBePaid(double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}
	public BetTransactionStatus getBetTransactionStatus() {
		return betTransactionStatus;
	}
	public void setBetTransactionStatus(BetTransactionStatus betTransactionStatus) {
		this.betTransactionStatus = betTransactionStatus;
	}
	
	
	
	
	

}
