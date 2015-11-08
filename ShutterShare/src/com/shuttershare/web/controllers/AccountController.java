package com.shuttershare.web.controllers;



import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
Description: Account controller class. Utilized Spring MVC framework to route incoming traffic to
				the website to the createevent.jsp and eventconfirmation.jsp pages. Also executes
				methods in UsersService and EventsService classes that will execute methods in the
				UsersDao and EventsDao classes in order to execute sql statements to create new events.
*/


// start of the AccountController class
@Controller
public class AccountController {
	
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

	
	// method that utilizes SpringFramework InitBinder annotation to check if the 
	// date entered in the account pages are in the correct format. 
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	// method createEvent that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /createevent. Logic in the method are executed and then redirects to 
	// the createevent jsp.
	@RequestMapping(value = "/createevent")
	public String createEvent(Model model){
		
		// creating object events of class Events() that will be passed as an argument to the jsp. 
		model.addAttribute("events", new Events());
		
		return "createevent";  // returning the string 'createevent' that will be used to redirect to the createevent page. 
	}
	
	
	// method doCreate that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /doCreate. Logic in the method are executed and then redirects to 
	// the createevent jsp or eventconfirmation jsp.
	@RequestMapping(value = "/docreate", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Events event, BindingResult result, Principal principal){
		
		// condition that executes if there are any errors in user entered input
		if(result.hasErrors()){
			
			return ("createevent");   // returning the string 'createevent' that will be used to redirect to the createevent page.
		}
		
		// declaring variable username that calls SpringSecurity method to retrieve the username.
		String username = principal.getName();
		
		// declaring list user object that will contain result obtained by the userService method getCurrent(). 
		List<Users> user = userService.getCurrent(username);
	
		
		// try catch - that will execute createEvent() method as long as it is not a 
		// a eventCode that already exists in the database. 
		try {
			// calling the method createEvent of class EventService with all the needed arguments.
			// executes logic that will create the event in the database
			eventService.createEvent(event.getEventCode(), user.get(0).getUserEmail(), 
					event.getDescription(), event.getDate(), event.getDays());
		
		// catch - executes if there is a duplicate primary key exception in the database 
		} catch (DuplicateKeyException e) {
			
			// displays custom error message to the screen utilizing SpringFramework BindingResult function.
			result.rejectValue("eventCode", "DuplicateKey.events.eventCode");	
			return "createevent";  // returning the string 'createevent' that will be used to redirect to the createevent page.
		}
		
		return "eventconfirmation";  // returning the string 'eventconfirmation' that will be used to redirect to the eventconfirmation page. 
	}
}
