package com.example.team_manager.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.team_manager.model.Calciatore;
import com.example.team_manager.service.ServiceTeams;
import java.util.*;

@RestController
public class Controller {
	
	@Autowired
	ServiceTeams service;
	
	@GetMapping("/teams")
	public ResponseEntity<?> getTeams() {
		
		Set<String> teams = new HashSet<String>();
		
		try {
			teams = service.getTeamList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(teams);
	}
	
	@GetMapping("/team/{nome}")
	public ResponseEntity<?> getTeam(@PathVariable String nome) {
		
		ArrayList<Calciatore> team = new ArrayList<>();
		
		
		try {
			team = service.loadTeam(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(team);
	}

}
