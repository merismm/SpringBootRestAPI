package com.task.springrestapi.match.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "players")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Player implements Serializable{
	private static final int serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "goals")
	private int goals;
	
	@Column(name = "age")
	private int age;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    @JsonIgnore
    private Team team;
	
	public Player() {}
	
	public Player(String name, int goals, int age) {
		this.name = name;
		this.goals = goals;
		this.age = age;
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
	
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	public int getGoals() {
		return this.goals;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Team getTeam() {
		return this.team;
	}
}
