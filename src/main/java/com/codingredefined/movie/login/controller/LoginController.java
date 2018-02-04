package com.codingredefined.movie.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView gotcha(HttpServletRequest request) {
		return new ModelAndView("forward:/index.jsp");
	}
	
}
