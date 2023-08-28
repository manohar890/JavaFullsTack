package com.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Movie")
public class Movie {

	@Id
	private String id;
	
	private String movieName;
	
	private double movieCollection;

	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMovieName() {
		return movieName;
	}



	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}



	public double getMovieCollection() {
		return movieCollection;
	}



	public void setMovieCollection(double movieCollection) {
		this.movieCollection = movieCollection;
	}



	public Movie(String id, String movieName, double movieCollection) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieCollection = movieCollection;
	}



	public Movie() {
		// TODO Auto-generated constructor stub
	}
}
