package com.codingredefined.movie.dashboard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
		
	@RequestMapping("/dashboard")
	public ModelAndView hello(HttpServletRequest request) {
		request.setAttribute("username", "username");
		System.out.println("request received - user dashboard");
		return new ModelAndView("forward:/homepage.jsp");
	}
	
}