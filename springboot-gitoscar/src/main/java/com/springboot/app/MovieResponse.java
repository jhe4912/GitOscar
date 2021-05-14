package com.springboot.app;

public class MovieResponse {
	
	private int filmYear;
	private int ceremonyYear;
	private int ceremonyNumber;
	private String category;
	private String nomineeName;
	private String filmName;
	private boolean winner;
	
	
	public int getFilmYear() {
		return filmYear;
	}
	public void setFilmYear(int year) {
		this.filmYear = year;
	}
	
	
	public int getCeremonyYear() {
		return ceremonyYear;
	}
	public void setCeremonyYear(int ceremonyYear) {
		this.ceremonyYear = ceremonyYear;
	}
	
	
	public int getCeremonyNumber() {
		return ceremonyNumber;
	}
	public void setCeremonyNumber (int ceremony) {
		this.ceremonyNumber = ceremony;
	}
	
	
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	
	
	public boolean getWinner() {
		return winner;
	}
	public void setWinner(boolean b) {
		this.winner = b;
	}
	

	

}
