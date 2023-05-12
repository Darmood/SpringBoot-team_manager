package com.example.team_manager.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.example.team_manager.model.Calciatore;

@Service
public class ServiceTeams {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	public ArrayList<String> getTeamList () throws Exception {
		
		ArrayList<String> teams = new ArrayList<>();
		
		 File folder = resourceLoader.getResource("classpath:teams").getFile();

	     File[] files = folder.listFiles();

	        for (File file : files) {
	            if (file.isFile() && file.getName().endsWith(".txt")) {
	            	
	            	String fileName = file.getName();
	            	int dotIndex = fileName.lastIndexOf('.');
	            	String team = (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
	            	teams.add(team);
	            }
	        }
	        
		return teams;
	}
	
	public ArrayList<Calciatore> loadTeam (String name) throws Exception {
		
		ArrayList<Calciatore> team = new ArrayList<>();
		
		File file = resourceLoader.getResource("classpath:teams/" + name + ".txt").getFile();
		if (file.isFile() && file.getName().endsWith(".txt")) {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));		
			String line = reader.readLine();
			
			while (line != null) {
				String[] elem = line.split(";");
				team.add(new Calciatore(elem[0],elem[1],elem[2],elem[3]));
				line = reader.readLine();
			}
			
			reader.close();		
		}
	        
	        
		return team;
	}

}
