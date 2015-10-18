package com.shuttershare.web.dao;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;



public class Events {
	
	@NotNull(message="Must create and event code")
	@Size(min=6, max=12, message="Event code must be between 6-12 characters")
	private String code;
	
	@NotNull(message="Must enter a event description")
	@Size(min=1, max=25, message="Must enter a description between 1-25 characters")
	private String description;
	
	@NotNull(message="Must enter a number of days for the event")
	private int days;
	
	
	@NotNull(message="Must enter a date for the event")
	private Date date;
	
	private String email;
	
	
	// default constructor
	public Events(){}
	
	// constructor that takes in arguments code, description, days, date
	public Events(String code, String description, int days, Date date) {
		super();
		this.code = code;
		this.description = description;
		this.days = days;
		this.date = date;
	}



	// get method for code
	public String getCode() {
		return code;
	}
	
	// set method for code
	public void setCode(String code) {
		this.code = code;
	}
	
	// get method for email
	public String getEmail() {
		return email;
	}
	
	// set method for email
	public void setEmail(String email) {
		this.email = email;
	}
	
	// get method for description
	public String getDescription() {
		return description;
	}
	
	// set method for description
	public void setDescription(String description) {
		this.description = description;
	}
	

	// get method for days
	public int getDays() {
		return days;
	}

	// set method for days
	public void setDays(int days) {
		this.days = days;
	}

	// get method for date
	public Date getDate() {
		return date;
	}

	// set method for date
	public void setDate(Date date) {
		this.date = date;
	}
	
}
