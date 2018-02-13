package com.codingredefined.movie.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {

	@Id
	@Column(name = "genre_id")
	private int genreId;
	private String genre;
	
	public Genre() {
	}
	
	public Genre(String genre) {
		this.genre = genre;
	}
	
	public int getGenreId() {
		return genreId;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
