package com.shuttershare.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shuttershare.web.dao.Users;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		model.addAttribute("users", new Users());
		return "newaccount";
	}
	
	@RequestMapping("/createaccount")
	public String createAccount(){
		return "accountconfirmation";
	}
}
