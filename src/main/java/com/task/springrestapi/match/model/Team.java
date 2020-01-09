package com.task.springrestapi.match.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "teams")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Team implements Serializable{
	private static final int serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "foundationYear")
	private String foundationYear;
	
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Player> players;
	
	public Team() {}
	
	public Team(String name, String foundationYear) {
		this.name = name;
		this.foundationYear = foundationYear;
	}
	
	public void setId(Int id) {
		this.id = id;
	}
	
	public Int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setFoundationYear(String foundationYear) {
		this.foundationYear = foundationYear;
	}
	
	public int getFoundationYear() {
		return this.foundationYear;
	}
	
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	public Set<Player> getPlayers(){
		return this.players;
	}
}
