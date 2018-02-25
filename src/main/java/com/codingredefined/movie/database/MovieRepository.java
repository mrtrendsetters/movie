package com.codingredefined.movie.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.codingredefined.movie.business.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

	List<Movie> findAll();

	List<Movie> findByMovieName(String movieName);

	@Transactional
	void deleteByMovieId(int parseInt);

	Movie findByMovieId(int parseInt);
	
}
