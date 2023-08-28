package com.movie.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
	
	Optional<Movie> findByMovieName(String s);
	
	Optional<Movie> findByMovieCollection(double c);

}
