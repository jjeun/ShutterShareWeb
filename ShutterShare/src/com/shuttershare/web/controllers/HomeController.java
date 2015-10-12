package com.shuttershare.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shuttershare.web.dao.Users;
import com.shuttershare.web.service.UsersService;

/*
  Author: Jesse Jeun
  Date: 10/12/2015
  CS188: Software Engineering - Professor Urness
  Description: Home controller class. Utilized Spring MVC framework to to route incoming traffic to
  				the website to the home page
  
*/


// start of the HomeController class - utilizes Spring controller annotation
@Controller
public class HomeController {
	
	private UsersService userService;	// declaring object 'userService' of type UsersService
	
	// start of setUserrService method that utilizes Spring Autowired annotation
	// has an argument of type UsersService. Initializes userService private variable to the
	// arguement that is passed in. 
	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	
	// start of method showHome() that utilizes Spring RequestMapping annotation.
	// matches any web request ending in "/" and will reroute incoming 
	// traffic to the 'home' page of the website.
	// Has one argument of type Model that is passed in. 
	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Users> users = userService.getCurrent(); // declaring variable 'user' of type Users.
													 // variable is initialized to value returned by 
													// getCurrent() method of object userService.
		
		model.addAttribute("users", users);  // creating attribute 'users' that is set to object 'users' from above.
											// 'users' attribute will passed to home.jsp where it can be used. 
		return "home";  // returning the string 'home' that will be used to redirect to the homepage. 
	}
	
}