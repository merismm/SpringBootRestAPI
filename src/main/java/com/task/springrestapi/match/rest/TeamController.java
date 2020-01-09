package com.task.springrestapi.match.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.task.springrestapi.match.exception.NotFoundException;
import com.task.springrestapi.match.jpa.TeamRepository;
import com.task.springrestapi.match.model.Team;


@RestController
@RequestMapping("/api")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
    @GetMapping("/teams")
    public List<Team> getAllTeams() {
    	return teamRepository.findAll();
    }
    
    @GetMapping("/teams/{id}")
    public Team getTeamByID(@PathVariable Int id) {
    	Optional<Team> optTeam = teamRepository.findById(id);
    	if(optTeam.isPresent()) {
    		return optTeam.get();
    	}else {
    		throw new NotFoundException("Team not found with id " + id);
    	}
    }
    
    @PostMapping("/teams")
    public Team createTeam(@Valid @RequestBody Team team) {
        return teamRepository.save(team);
    }
    
    @PutMapping("/teams/{id}")
    public Team updateTeam(@PathVariable Int id,
                                   @Valid @RequestBody Team teamUpdated) {
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(teamUpdated.getName());
                    team.setFoundationYear(teamUpdated.getFoundationYear());
                    return teamRepository.save(team);
                }).orElseThrow(() -> new NotFoundException("Team not found with id " + id));
    }
    
    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable Int id) {
        return teamRepository.findById(id)
                .map(team -> {
                    teamRepository.delete(team);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new NotFoundException("Team not found with id " + id));
    }
}