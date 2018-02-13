package com.codingredefined.movie.dashboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
		
	@RequestMapping("/dashboard")
	public ModelAndView hello(HttpServletRequest request) {
		if(request.getSession().getAttribute("user_id") != null) {
			return new ModelAndView("dashboard/homepage");
		} else { 
			return new ModelAndView("forward:/login");
		}
		
	}
	
}
