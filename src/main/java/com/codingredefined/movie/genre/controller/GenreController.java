package com.codingredefined.movie.genre.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.codingredefined.movie.business.model.Genre;
import com.codingredefined.movie.database.GenreRepository;

@RestController
@RequestMapping("/genre")
public class GenreController {
	
	@Autowired
	GenreRepository repository;
	
	@RequestMapping("/add")
	public ModelAndView addGenre() {
		return new ModelAndView("genre/addGenre");
	}

	@RequestMapping("/addToDB")
	public ModelAndView addGenreToDB(@RequestParam("genre") String genreName) {
		Genre genre = new Genre(genreName);
		repository.save(genre);
		return new ModelAndView("redirect:/dashboard");
	}
	
	@RequestMapping("/viewAll")
	public ModelAndView viewAllGenre(HttpServletRequest request) {
		List<Genre> genreList = repository.findAll();
		request.setAttribute("genreList", genreList);
		return new ModelAndView("genre/genre");
	}

	@RequestMapping("/delete/{genreId}")
	public ModelAndView deleteGenre(@PathVariable("genreId") String genreId, HttpServletRequest request) {
		repository.deleteByGenreId(Integer.parseInt(genreId));
		List<Genre> genreList = repository.findAll();
		request.setAttribute("genreList", genreList);
		return new ModelAndView("redirect:/genre/viewAll");
	}
	
}
