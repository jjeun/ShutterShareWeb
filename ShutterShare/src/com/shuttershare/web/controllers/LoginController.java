package com.shuttershare.web.controllers;

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
	

	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/loggedout")
	public String showLogOut(){
		return "loggedout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		model.addAttribute("users", new Users());
		return "newaccount";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid Users users, BindingResult result){
		
		if(result.hasErrors()){
			return "newaccount";
		}
		
		users.setAuthority("admin");
		users.setEnabled(true);
		users.setUsername(users.getUserEmail());
		
		// try catch - that will execute createAccount() method as long as it is not a 
		// a username/email that already exsits in the database. 
		try {
			userService.createAccount(users);
			
		} catch (DuplicateKeyException e) {
			
			result.rejectValue("userEmail", "DuplicateKey.users.userEmail");	
			return "newaccount";
		}
		
		return "accountconfirmation";
	}
}
