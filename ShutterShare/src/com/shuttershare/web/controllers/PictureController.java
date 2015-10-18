package com.shuttershare.web.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttershare.web.dao.Events;
import com.shuttershare.web.service.EventsService;
import com.shuttershare.web.service.PicturesService;
import com.shuttershare.web.service.UsersService;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: Picuture controller class. Utilized Spring MVC framework to route incoming traffic to
				the website to the pictureview.jsp and eventpictures.jsp pages. Also executes
				methods in UsersService, PicturesService and EventsService classes that will execute methods in the
				UsersDao, PicturesDao, and EventsDao classes in order to execute sql statements to access
				users created events and stored pictures.
*/


// start of the PictureController class
@Controller
public class PictureController {

	private UsersService userService;	// declaring object 'userService' of type UsersService
	private EventsService eventService;	// declaring object 'eventService' of type UsersService
	private PicturesService pictureService;	// declaring object 'pictureService' of type PicturesService
	
	
	
	
	
	
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
	
	
	
	// start of setPicturesService method that utilizes Spring Autowired annotation
	// has an argument of type PicturesService. Initializes pictureService private variable to the
	// argument that is passed in. 
	@Autowired
	public void setPicturesService(PicturesService pictureService) {
		this.pictureService = pictureService;
	}
	
	
	@RequestMapping(value = "/eventpictures")
	public String createEvent(Model model){
		
		model.addAttribute("events", new Events());
		
		return "eventpictures";  // returning the string 'createpictures' that will be used to redirect to the event picture page. 
	}
	
	
	
	@RequestMapping(value = "/generatepic", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid Events event, BindingResult result){
		
		return "pictureview";  // returning the string 'home' that will be used to redirect to the homepage. 
	}
	

}
