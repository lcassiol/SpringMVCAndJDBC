package com.springmvc.model;

public class Movie {

	private Long id;
	private String name;
	private String director;
	private String writers;
	private int year;
	private String sinopse;
	private String stars;
	private String gender;
	
	
	public Movie(String name, String director, String writers, int year, String sinopse, String stars, String gender) {
		setName(name);
		setDirector(director);
		setWriters(writers);
		setYear(year);
		setSinopse(sinopse);
		setStars(stars);
		setGender(gender);
	}
	
	public Movie() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriters() {
		return writers;
	}
	public void setWriters(String writers) {
		this.writers = writers;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
