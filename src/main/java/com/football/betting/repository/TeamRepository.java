package com.football.betting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.betting.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
