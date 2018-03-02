package com.codingredefined.movie.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@Column(name = "movie_id")
	private int movieId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "movie_name")
	private String movieName;
	private String genre1;
	private String genre2;
	private String genre3;
	@Column(name = "release_year")
	private int releaseYear;
	private String rating;
	@Column(name = "tobedownloaded")
	private Timestamp toBeDownloaded;
	@Column(name = "tobewatched")
	private Timestamp toBeWatched;
	private Timestamp watched;
	private int pg;
	
	public Movie() {
		this.toBeDownloaded = new Timestamp(System.currentTimeMillis());
	}
	
	public Movie(String movieName, String genre1, String releaseYear, String rating) {
		this.movieName = movieName;
		this.genre1 = genre1;
		this.releaseYear = Integer.parseInt(releaseYear);
		this.rating = rating;
	}

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre1() {
		return genre1;
	}
	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}
	public String getGenre2() {
		return genre2;
	}
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}
	public String getGenre3() {
		return genre3;
	}
	public void setGenre3(String genre3) {
		this.genre3 = genre3;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Timestamp getToBeDownloaded() {
		return toBeDownloaded;
	}
	public void setToBeDownloaded(Timestamp toBeDownloaded) {
		this.toBeDownloaded = toBeDownloaded;
	}
	public Timestamp getToBeWatched() {
		return toBeWatched;
	}
	public void setToBeWatched(Timestamp toBeWatched) {
		this.toBeWatched = toBeWatched;
	}
	public Timestamp getWatched() {
		return watched;
	}
	public void setWatched(Timestamp watched) {
		this.watched = watched;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	
}
