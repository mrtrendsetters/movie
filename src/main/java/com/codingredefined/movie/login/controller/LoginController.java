package com.codingredefined.movie.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.codingredefined.movie.business.model.User;
import com.codingredefined.movie.database.UserRepository;

@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/login")
	public ModelAndView gotcha(HttpServletRequest request) {
		if(request.getSession().getAttribute("user_id") == null) {
			return new ModelAndView("forward:/signin.jsp");
		} else {
			return new ModelAndView("redirect:/dashboard");
		}
	}
	
	@RequestMapping("/validateCredentials")
	public ModelAndView validateCredentials(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		
		User user = userRepository.findByUsernameAndPassword(username, password);
		if(user != null) {
			request.getSession().setAttribute("user_name", user.getUser_name());
			request.getSession().setAttribute("user_id", user.getUser_id());
			return new ModelAndView("redirect:dashboard");
		} else {
			return new ModelAndView("redirect:/signin.jsp");
		}
		
	}
	
}
