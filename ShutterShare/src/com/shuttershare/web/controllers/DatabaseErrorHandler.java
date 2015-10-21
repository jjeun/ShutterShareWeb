package com.shuttershare.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: DatabaseErrorHandler controller class. Utilized Spring MVC framework to handle
	error exceptions from the database. Will reroute all database exceptions to the error.jsp page. 

*/



@ControllerAdvice
public class DatabaseErrorHandler {
	
	// start of the handleDatabaseException method that utilizes Sprin ExceptionHandler annotation
	// has an argument of DatAccessException.class. Method catches all database exceptions and forwards
	// to error.jsp page to notify user. 
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){
		ex.printStackTrace();
		return "error";
	}

}
