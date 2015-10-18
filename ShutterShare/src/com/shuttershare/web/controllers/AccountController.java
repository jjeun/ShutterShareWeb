package com.shuttershare.web.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/createevent")
	public String createEvent(Model model){
		
		model.addAttribute("events", new Events());
		
		return "createevent";  // returning the string 'home' that will be used to redirect to the homepage. 
	}
	
	
	
	@RequestMapping(value = "/docreate", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Events event, BindingResult result){
		
		if(result.hasErrors()){
			
			return ("createevent");
		}
		
		List<Users> user = userService.getCurrent();
		
		eventService.createEvent(event.getCode(), user.get(0).getEmail(), 
				event.getDescription(), event.getDate(), event.getDays());
		
		return "eventconfirmation";  // returning the string 'home' that will be used to redirect to the homepage. 
	}

}
