package com.football.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.betting.models.BetTransaction;

@Repository
public interface BetTransactionRepository extends JpaRepository<BetTransaction, Integer> {

}
