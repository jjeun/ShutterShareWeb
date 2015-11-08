package com.shuttershare.web.controllers;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shuttershare.web.dao.Pictures;
import com.shuttershare.web.service.PicturesService;


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


// start of the PictureController class. Utilizes SpringFramework Controller annotation
@Controller
public class PictureController {

	private PicturesService pictureService;	// declaring object 'pictureService' of type PicturesService
	
	
	// start of setPicturesService method that utilizes Spring Autowired annotation
	// has an argument of type PicturesService. Initializes pictureService private variable to the
	// argument that is passed in. 
	@Autowired
	public void setPicturesService(PicturesService pictureService) {
		this.pictureService = pictureService;
	}
	
	
	
	// method eventPics that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /eventpics. Logic in the method are executed and then redirects to 
	// the eventpics jsp.
	@RequestMapping(value = "/eventpics")
	public String eventPics(Model model, HttpServletRequest request){
		
		// declaring variables and initializing them to values passed in with the HttpRequest
		String eventcode = request.getParameter("eventcode");
		String description = request.getParameter("description");
		
		// declaring list object of type Pictures. Initialized to the results of getPictures method of class PictureService.
		List<Pictures> pictures = pictureService.getPictures(eventcode);
		
		// declaring variables and initializing them values that will be passed to the jsp
		model.addAttribute("description", description);
		model.addAttribute("pictures", pictures);
		
		return "eventpics";  // returning the string 'createpictures' that will be used to redirect to the event picture page. 
	}
	
	
	
	// method deletePic that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /deletepic. Logic in the method are executed and then redirects to 
	// the eventpics jsp.
	@RequestMapping(value = "/deletepic", method=RequestMethod.POST)
	public String deletePic(Model model,@RequestParam("picture") String picture, @RequestParam("eventCode") String eventCode, 
				@RequestParam("description") String description){
		
		// executing the deletePic method of class PictureService
		pictureService.deletePic(picture);
		
		// declaring list object of type Pictures. Initialized to the results of getPictures method of class PictureService.
		List<Pictures> pictures = pictureService.getPictures(eventCode);
		
		// declaring variables and initializing them values that will be passed to the jsp
		model.addAttribute("eventcode", eventCode);
		model.addAttribute("description", description);
		model.addAttribute("pictures", pictures);
		
		return "eventpics";  // returning the string 'eventpics' that will be used to redirect to the event pic page. 
	}
	
}
