package com.Spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String []args) {
		AnnotationConfigApplicationContext ap=new AnnotationConfigApplicationContext(Config.class);
		Movie m=ap.getBean(Movie.class);
		m.setMovieName("The Firm");
		m.setMovieId("Moo1");
		m.setMovieActor("Tom Cruise");
		m.show();
		ap.close();
	}

}
