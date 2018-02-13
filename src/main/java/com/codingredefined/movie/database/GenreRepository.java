package com.codingredefined.movie.database;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.codingredefined.movie.business.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	List<Genre> findAll();

	@Transactional
	void deleteByGenreId(int genreId);
	
}
