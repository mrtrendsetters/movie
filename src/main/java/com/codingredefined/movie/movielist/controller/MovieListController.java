package com.codingredefined.movie.movielist.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codingredefined.movie.business.model.Genre;
import com.codingredefined.movie.business.model.Movie;
import com.codingredefined.movie.database.GenreRepository;
import com.codingredefined.movie.database.MovieRepository;

@Controller
@RequestMapping("/movie")
public class MovieListController {

	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@RequestMapping("/viewAll")
	public ModelAndView viewAllMovie(HttpServletRequest request) {
		List<Movie> movieList = movieRepository.findAll();
		request.setAttribute("movieList", movieList);
		return new ModelAndView("movie/movie");
	}
	
	@RequestMapping("/add")
	public ModelAndView addMovie(HttpServletRequest request) {
		List<Genre> genreList = genreRepository.findAll();
		request.setAttribute("genreList", genreList);
		return new ModelAndView("movie/addMovie");
	}
	
	@RequestMapping("/addToDB")
	public ModelAndView addMovieToDB(HttpServletRequest request) {
		String movieName = request.getParameter("movieName");
		String genre1 = request.getParameter("genre1");
		String genre2 = request.getParameter("genre2");
		String genre3 = request.getParameter("genre3");
		String releaseYear = request.getParameter("releaseYear");
		String rating = request.getParameter("rating");
		String status = request.getParameter("status");
		String pg = request.getParameter("pg");
		Movie movie = new Movie(movieName, genre1, releaseYear, rating);
		if(!(genre2.equals("null"))) {
			movie.setGenre2(genre2);
		}
		if(!(genre3.equals("null"))) {
			movie.setGenre3(genre3);
		}
		switch(status) {
			case "toBeDownloaded":
				movie.setToBeDownloaded(new Timestamp(System.currentTimeMillis()));
				break;
			case "downloaded":
				movie.setToBeDownloaded(new Timestamp(System.currentTimeMillis()));
				movie.setToBeWatched(new Timestamp(System.currentTimeMillis()));
				break;
			case "watched":
				movie.setToBeDownloaded(new Timestamp(System.currentTimeMillis()));
				movie.setToBeWatched(new Timestamp(System.currentTimeMillis()));
				movie.setWatched(new Timestamp(System.currentTimeMillis()));
				break;
		}
		if(!(pg == null)) {
			movie.setPg(Integer.parseInt(pg));
		}
		movieRepository.save(movie);
		return new ModelAndView("redirect:/movie/viewAll");
	}
	
	@RequestMapping("/checkDuplicate")
	@ResponseBody
	public String checkDuplicate(HttpServletRequest request, @RequestParam("movieName") String movieName) {
		List<Movie> matchingMovieList = movieRepository.findByMovieName(movieName);
		if(matchingMovieList.size() == 0) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@RequestMapping("/delete/{movieId}")
	public ModelAndView deleteMovie(@PathVariable("movieId") String movieId, HttpServletRequest request) {
		movieRepository.deleteByMovieId(Integer.parseInt(movieId));
		List<Movie> movieList = movieRepository.findAll();
		request.setAttribute("movieList", movieList);
		return new ModelAndView("redirect:/movie/viewAll");
	}
	
	@RequestMapping("/update/{movieId}")
	public ModelAndView updateMovie(@PathVariable("movieId") String movieId, HttpServletRequest request) {
		Movie movie = movieRepository.findByMovieId(Integer.parseInt(movieId));
		List<Genre> genreList = genreRepository.findAll();
		request.setAttribute("genreList", genreList);
		request.setAttribute("movie", movie);
		return new ModelAndView("movie/updateMovie");
	}
	
	@RequestMapping("/updateToDB")
	public ModelAndView updateMovieToDB(HttpServletRequest request) {
		String movieId = request.getParameter("movieId");
		String movieName = request.getParameter("movieName");
		String genre1 = request.getParameter("genre1");
		String genre2 = request.getParameter("genre2");
		String genre3 = request.getParameter("genre3");
		String releaseYear = request.getParameter("releaseYear");
		String rating = request.getParameter("rating");
		String status = request.getParameter("status");
		String pg = request.getParameter("pg");
		
		Movie movie = movieRepository.findByMovieId(Integer.parseInt(movieId));
		
		if(movie == null) {
			System.out.println("Movie returned null");
			System.exit(0);
		}
		
		movie.setMovieName(movieName);
		
		if(!(genre1.equals("null"))) {
			movie.setGenre1(genre1);
		} 
		if(!(genre2.equals("null"))) {
			movie.setGenre2(genre2);
		} else {
			movie.setGenre2(null);
		}
		if(!(genre3.equals("null"))) {
			movie.setGenre3(genre3);
		} else {
			movie.setGenre3(null);
		}
		
		movie.setReleaseYear(Integer.parseInt(releaseYear));
		movie.setRating(rating);
		
		switch(status) {
			case "toBeDownloaded":
				movie.setToBeDownloaded(new Timestamp(System.currentTimeMillis()));
				movie.setToBeWatched(null);
				movie.setWatched(null);
				break;
			case "downloaded":
				movie.setToBeDownloaded(new Timestamp(System.currentTimeMillis()));
				movie.setToBeWatched(new Timestamp(System.currentTimeMillis()));
				movie.setWatched(null);
				break;
			case "watched":
				movie.setToBeDownloaded(new Timestamp(System.currentTimeMillis()));
				movie.setToBeWatched(new Timestamp(System.currentTimeMillis()));
				movie.setWatched(new Timestamp(System.currentTimeMillis()));
				break;
		}
		if(!(pg == null)) {
			movie.setPg(Integer.parseInt(pg));
		}
		movieRepository.save(movie);
		return new ModelAndView("redirect:/movie/viewAll");
	}
	
}
