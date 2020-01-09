package com.task.springrestapi.match.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.springrestapi.match.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Int> {
	List<Player> findByTeamId(Int teamId);	
}
