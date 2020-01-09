package com.task.springrestapi.match.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.springrestapi.match.model.Team;

public interface TeamRepository extends JpaRepository<Team, Int> {
}