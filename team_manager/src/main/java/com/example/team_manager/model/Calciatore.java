package com.example.team_manager.model;

public class Calciatore {
	
	String cognome;
	String nome;
	String ruolo;
	String forza;
	
	public Calciatore(String cognome, String nome, String ruolo, String forza) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.ruolo = ruolo;
		this.forza = forza;
	}
	
	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public String getForza() {
		return forza;
	}

	@Override
	public String toString() {
		return "Calciatore [cognome=" + cognome + ", nome=" + nome + ", ruolo=" + ruolo + ", forza=" + forza + "]";
	}
}
