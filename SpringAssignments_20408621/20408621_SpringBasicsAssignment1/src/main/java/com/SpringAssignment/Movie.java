package com.SpringAssignment;

public class Movie {
	private String movieId;
	private String movieName;
	private String movieActor;
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieActor() {
		return movieActor;
	}
	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}
	
	public void show() {
		System.out.println("Movie Id := "+movieId+"\nMovie Name := "+movieName+"\nMovie Actor : = "+movieActor );
	}
	

}
