package com.shuttershare.web.dao;

/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: Users class - Holds the values id, firstName, lastName, email, password that 
			is retrieved from the sql database. Contains setters and getter to access and 
			store the values.

*/


// start of class Users
public class Users {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	// get method for id
	public int getId() {
		return id;
	}
	
	// set method for id
	public void setId(int id) {
		this.id = id;
	}
	
	// get method for firstName
	public String getFirstName() {
		return firstName;
	}
	
	// set method for firstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// get method for lastName
	public String getLastName() {
		return lastName;
	}
	
	// set method for lastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// get method for email
	public String getEmail() {
		return email;
	}
	
	// set method for email
	public void setEmail(String email) {
		this.email = email;
	}
	
	// get method for password
	public String getPassword() {
		return password;
	}
	
	// set method for password
	public void setPassword(String password) {
		this.password = password;
	}
	
}
