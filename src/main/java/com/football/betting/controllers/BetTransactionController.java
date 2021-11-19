package com.football.betting.controllers;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.football.betting.service.BetTransactionService;

@Controller
public class BetTransactionController {
	
	@Resource
	private BetTransactionService betTransactionService;	
	
	@Scheduled(cron = " 0 * * ? * *")
	@GetMapping(path = "/process-bet-transactions")
	public void processBettingTransaction() {
		betTransactionService.processBetTransaction();
	}

}
