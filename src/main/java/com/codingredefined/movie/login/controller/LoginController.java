package com.codingredefined.movie.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView gotcha(HttpServletRequest request) {
		return new ModelAndView("forward:/signin.jsp");
	}
	
	@RequestMapping("/validateCredentials")
	public ModelAndView validateCredentials(@RequestParam("username") String username, @RequestParam("password") String password) {
		if(username.equalsIgnoreCase("username") && password.equalsIgnoreCase("password")) {
			return new ModelAndView("redirect:dashboard");
		} else {
			System.out.println("Enter else");
			return new ModelAndView("redirect:/signin.jsp");
		}
	}
	
}
