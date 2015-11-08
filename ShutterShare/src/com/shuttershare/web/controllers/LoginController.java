package com.shuttershare.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttershare.web.dao.Users;
import com.shuttershare.web.service.UsersService;

/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: Login Controller class - handles incoming url request and values then sends calls
	appropriate functions before redirecting to jsp.

*/



// Start of LoginController class. Utilizes SpringFrame work Controller annotation
@Controller
public class LoginController {
	
	private UsersService userService;	// declaring object 'userService' of type UsersService

	// start of setUserrService method that utilizes Spring Autowired annotation
	// has an argument of type UsersService. Initializes userService private variable to the
	// argument that is passed in. 
	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}
	

	// method showLogin that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /login. Logic in the method are executed and then redirects to 
	// the login jsp.
	@RequestMapping("/login")
	public String showLogin(){
		return "login";  // returning the string 'login' that will be used to redirect to the login page.
	}
	
	
	// method showLogOut that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /loggedout. Logic in the method are executed and then redirects to 
	// the loggedout jsp.
	@RequestMapping("/loggedout")
	public String showLogOut(){
		return "loggedout"; // returning the string 'loggedout' that will be used to redirect to the log out page.
	}
	
	
	// method showNewAccount that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /newaccount. Logic in the method are executed and then redirects to 
	// the newaccount jsp.
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		model.addAttribute("users", new Users());  // creating a new object users of type Users that will passed to jsp
		return "newaccount";   // returning the string 'newaccount' that will be used to redirect to the new account page.
	}
	
	
	// method createAccount that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /createaccount. Logic in the method are executed and then redirects to 
	// the newaacount jsp or accountconfirmation jsp.
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid Users users, BindingResult result){
		
		// condition that executes if there are any errors in user entered input
		if(result.hasErrors()){
			return "newaccount";  // returning the string 'newaccount' that will be used to redirect to the newaccount page.
		}
		
		users.setAuthority("admin");  // calling setAuthority method for object users
		users.setEnabled(true);		// calling setEnable method for object users
		users.setUsername(users.getUserEmail());  // calling setUsername method for object users
		
		// try catch - that will execute createAccount() method as long as it is not a 
		// a username/email that already exists in the database. 
		try {
			userService.createAccount(users);  // executing createAccount method of class UserService to create a new account
		
		// catch - executes if there is duplicate primary key in the database
		} catch (DuplicateKeyException e) {
			
			// displays custom error message to the screen utilizing SpringFramework BindingResult function.
			result.rejectValue("userEmail", "DuplicateKey.users.userEmail");	
			return "newaccount";  // returning the string 'newaccount' that will be used to redirect to the newaccount page.
		}
		
		return "accountconfirmation";  // returning the string 'accountconfirmation' that will be used to redirect to the accountconfirmation page.
	}
	
	
	
	// method showSettings that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /settings. Logic in the method are executed and then redirects to 
	// the updateaccount jsp.
	@RequestMapping("/settings")
	public String showSettings(Model model, Principal principal){
		
		// declaring variable username that calls SpringSecurity method to retrieve the username. 
		String username = principal.getName();
		
		// declaring list objec user of type Users. Intialized to result of method getCurrent of class UserService
		List<Users> user = userService.getCurrent(username);
		
		// declaring variable user that intialized to first element of list object user. Will be passed to jsp.
		model.addAttribute("user", user.get(0));
		
		// declaring new objec users of type Users that will be passed to the jsp
		model.addAttribute("users", new Users());
		
		return "updateaccount";  // returning the string 'updateaccount' that will be used to redirect to the updateaccount page.
	}
	
	
	// method updateAccount that utilizes SpringFramwork RequestMapping annotation which directs
	// incoming url ending in /updateaccount. Logic in the method are executed and then redirects to 
	// the updateconfirmation jsp.
	@RequestMapping(value="/updateaccount", method=RequestMethod.POST)
	public String updateAccount(@Valid Users users, BindingResult result){
		
		// condition that executes if there are any errors in user entered input
		if(result.hasErrors()){
			return "updateaccount";  // returning the string 'updateaccount' that will be used to redirect to the updateaccount page.
		}
		
		
		// try catch - that will execute createAccount() method as long as it is not a 
		// a username/email that already exists in the database. 
		try {
			userService.updateAccount(users);
		
		// catch - executes if there is duplicate primary key in the database
		} catch (DuplicateKeyException e) {
			
			// displays custom error message to the screen utilizing SpringFramework BindingResult function.
			result.rejectValue("userEmail", "DuplicateKey.users.userEmail");	
			return "updateaccount";  // returning the string 'updateaccount' that will be used to redirect to the updateaccount page.
		}
		
		return "updateconfirmation";  // returning the string 'updateconfirmation' that will be used to redirect to the updateconfirmation page.
	}
}
