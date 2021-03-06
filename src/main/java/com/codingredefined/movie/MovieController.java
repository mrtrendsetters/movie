package com.codingredefined.movie;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

	@RequestMapping("/")
	public ModelAndView defaultMapper(HttpServletRequest request) {
		if(request.getSession().getAttribute("user_id") == null) {
			return new ModelAndView("forward:/login");
		} else { 
			return new ModelAndView("forward:/dashboard");
		}
	}
	
}
