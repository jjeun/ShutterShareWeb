package com.shuttershare.web.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.shuttershare.web.validations.ValidEmail;

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
	
	private String username;
	
	@NotNull(message="Must enter a first name.")
	private String firstName;
	
	@NotNull(message="Must enter a last name.")
	private String lastName;
	
	@NotNull(message="Must enter a email.")
	@ValidEmail(message="This email is not valid")
	@Pattern(regexp=".*\\@.*\\..*", message="This doesn't appear to be a valid email address.")
	private String email;
	
	@NotNull(message="Must enter a password.")
	private String password;
	
	@NotNull(message="Must enter an address.")
	private String address;
	
	@NotNull(message="Must enter a city.")
	private String city;
	
	@NotNull(message="Must enter a state.")
	private String state;
	
	@NotNull(message="Must enter a telephone number.")
	private String telephone;
	
	@NotNull(message="Must enter a zipcode.")
	@Pattern(regexp="[0-9]*")
	private int zipcode;
	
	
	// default constructor
	public Users(){}
	
	// constructor that takes all the arguments
	public Users(String username, String firstName, String lastName, String email, String password, String address,
			String city, String state, String telephone, int zipcode) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.telephone = telephone;
		this.zipcode = zipcode;
	}



	// get method for username
	public String getUsername() {
		return username;
	}
	
	// set method for username
	public void setUsername(String username) {
		this.username = username;
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

	// get method for address
	public String getAddress() {
		return address;
	}

	// set method for address
	public void setAddress(String address) {
		this.address = address;
	}

	// get method for city
	public String getCity() {
		return city;
	}

	// set method for city
	public void setCity(String city) {
		this.city = city;
	}

	// get method for state
	public String getState() {
		return state;
	}

	// set method for state
	public void setState(String state) {
		this.state = state;
	}

	// get method for telephone
	public String getTelephone() {
		return telephone;
	}

	// set method for telephone
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	// get method for zipcode
	public int getZipcode() {
		return zipcode;
	}

	// set method for zipcode
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
