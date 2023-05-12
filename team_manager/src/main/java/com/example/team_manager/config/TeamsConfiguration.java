package com.example.team_manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.team_manager.model.Calciatore;

@Configuration
public class TeamsConfiguration {

	@Autowired
	ResourceLoader resourceLoader;

	@Bean
	public HashMap<String, ArrayList<Calciatore>> savedTeams() throws Exception {

		HashMap<String, ArrayList<Calciatore>> savedTeams = new HashMap<>();

		File folder = resourceLoader.getResource("classpath:teams").getFile();

		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".txt")) {

				String fileName = file.getName();
				int dotIndex = fileName.lastIndexOf('.');
				String team = (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);

				ArrayList<Calciatore> calciatori = new ArrayList<>();

				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();

				while (line != null) {
					String[] elem = line.split(";");
					calciatori.add(new Calciatore(elem[0], elem[1], elem[2], elem[3]));
					line = reader.readLine();
				}

				reader.close();

				savedTeams.put(team, calciatori);

			}
		}

		return savedTeams;
	}

}
