package com.football.betting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FootballBettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballBettingApplication.class, args);
	}

}
