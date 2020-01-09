package com.task.springrestapi.match.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.task.springrestapi.match.exception.NotFoundException;
import com.task.springrestapi.match.jpa.PlayerRepository;
import com.task.springrestapi.match.jpa.TeamRepository;
import com.task.springrestapi.match.model.Player;

@RestController
@RequestMapping("/api")
public class PlayerController {
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
    @GetMapping("/teams/{teamId}/players")
    public List<Player> getContactByTeamId(@PathVariable Int teamId) {
    	
        if(!teamRepository.existsById(teamId)) {
            throw new NotFoundException("Team not found!");
        }
    	
    	return playerRepository.findByTeamId(teamId);
    }
    
    @PostMapping("/teams/{teamId}/players")
    public Player addPlayer(@PathVariable Int teamId,
                            @Valid @RequestBody Player player) {
        return teamRepository.findById(teamId)
                .map(team -> {
                    player.setTeam(team);
                    return playerRepository.save(player);
                }).orElseThrow(() -> new NotFoundException("Team not found!"));
    }
    
    @PutMapping("/teams/{teamId}/players/{playerId}")
    public Player updatePlayer(@PathVariable Int teamId,
    								@PathVariable Int playerId,
    								@Valid @RequestBody Player playerUpdated) {
    	
    	if(!teamRepository.existsById(teamId)) {
    		throw new NotFoundException("Team not found!");
    	}
    	
        return playerRepository.findById(playerId)
                .map(player -> {
                    player.setName(playerUpdated.getName());
                    player.setGoals(playerUpdated.getGoals());
					player.setAge(playerUpdated.getAge());
                    return playerRepository.save(player);
                }).orElseThrow(() -> new NotFoundException("Player not found!"));
    }
    
    @DeleteMapping("/teams/{teamId}/players/{playerId}")
    public String deletePlayer(@PathVariable Int teamId,
    							   @PathVariable Int playerId) {
    	
    	if(!teamRepository.existsById(teamId)) {
    		throw new NotFoundException("Team not found!");
    	}
    	
        return playerRepository.findById(playerId)
                .map(player -> {
                    playerRepository.delete(player);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
    }
}
