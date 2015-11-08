package com.shuttershare.web.controllers;



import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttershare.web.dao.Events;
import com.shuttershare.web.dao.Users;
import com.shuttershare.web.service.EventsService;
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
	private EventsService eventService;	// declaring object 'eventService' of type UsersService

	
	
	// start of setUserrService method that utilizes Spring Autowired annotation
	// has an argument of type UsersService. Initializes userService private variable to the
	// argument that is passed in. 
	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}
	

		
	// start of setEventService method that utilizes Spring Autowired annotation
	// has an argument of type EventsService. Initializes eventService private variable to the
	// argument that is passed in. 
	@Autowired
	public void setEventsService(EventsService eventService) {
		this.eventService = eventService;
	}

	
	// start of method showHome() that utilizes Spring RequestMapping annotation.
	// matches any web request ending in "/" and will reroute incoming 
	// traffic to the 'home' page of the website.
	// Has one argument of type Model that is passed in. 
	@RequestMapping("/")
	public String showHome(Model model, Principal principal){
		
		// declaring variable username that calls SpringSecurity method to retrieve the username. 
		String username = principal.getName();
		
		// declaring a new list userEvents object.
		List<Events> userEvents = new ArrayList<Events>();
		
		List<Users> users = userService.getCurrent(username); // declaring variable 'user' of type Users.
													 // variable is initialized to value returned by 
													// getCurrent() method of object userService.
		
		// declaring object events of type Events and initializing the result returned by 
		// getCurrent method of EventService class
		List<Events> events = eventService.getCurrent(username);
		
		// for-loop the iterates thru each element of events and adds elements to userEvent list 
		// where the email's in objects users and events are the same.
		for(Events e:events){
		
			// condition that executes if emails in objects users and events are equal
			if (e.getEmail().equals(users.get(0).getUserEmail())){
				userEvents.add(e);  // adding element in events list to list userEvents
			}
		}
		
		
		model.addAttribute("users", users);  // creating variable 'users' that is set to object 'users' from above.
											// 'users' attribute will passed to home.jsp where it can be used. 
		
		model.addAttribute("events", userEvents); // creating variable events that is initalized to userEvents list which
													// will be passed and used in home jsp
		
		return "home";  // returning the string 'home' that will be used to redirect to the homepage. 
	}
	
	
	
	// method deleteEvent that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /deleteevent. Logic in the method are executed and then redirects to 
	// the deleteconfirmation jsp.
	@RequestMapping(value="/deleteevent", method=RequestMethod.POST)
	public String deleteEvent(Model model, HttpServletRequest result){

		// creating variable eCode of type string that will be initialized to the eventCode
		// passed as part of the HttpRequest 
		String eCode = result.getParameter("eventCode");

		// executing method deleteEvent of EventService class
		eventService.deleteEvent(eCode);
			
		return "deleteconfirmation";  // returning the string 'deleteconfirmation' that will be used to redirect to the deleteconfirmation page. 

	}
	
	
	// method aboutPage that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /about. Logic in the method are executed and then redirects to 
	// the aboutpage jsp.
	@RequestMapping("/about")
	public String aboutPage(Model model){
			
		return "aboutpage";  // returning the string 'aboutpage' that will be used to redirect to the about page. 

	}
	
	
	// method aboutlogin that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /abouthome. Logic in the method are executed and then redirects to 
	// the aboutpage jsp.
	@RequestMapping("/abouthome")
	public String aboutHome(Model model){
			
		return "aboutlogin";  // returning the string 'aboutlogin' that will be used to redirect to the about page. 

	}
}
