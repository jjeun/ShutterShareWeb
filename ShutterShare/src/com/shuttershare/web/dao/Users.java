package com.shuttershare.web.dao;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@ValidEmail
	private String userEmail;
	
	@Size(min=6)
	private String password;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank
	@Pattern(regexp="[A-Z]{2}")
	private String state;
	
	@NotBlank
	@Pattern(regexp="[0-9]{3}-[0-9]{3}-[0-9]{4}")
	private String telephone;
	
	@NotBlank
	@Pattern(regexp="[0-9]*")
	@Size(min=5)
	private String zipcode;
	
	private String username;
	
	private String authority;
	
	private boolean enabled;
	
	
	// default constructor
	public Users(){}
	
	// constructor that takes all the arguments
	public Users(String username, String firstName, String lastName, String userEmail, String password, String address,
			String city, String state, String telephone, String zipcode) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
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
	public String getUserEmail() {
		return userEmail;
	}
	
	// set method for email
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		this.username = userEmail;
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
	public String getZipcode() {
		return zipcode;
	}

	// set method for zipcode
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	// get method for authority
	public String getAuthority() {
		return authority;
	}

	// set method for authority
	public void setAuthority(String authority) {
		this.authority = authority;
	}


	// get method for enabled
	public boolean getEnabled() {
		return enabled;
	}
	
	// set method for enabled
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}	

