package com.shuttershare.web.dao;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: Events class 

*/


// Java Bean Events 

public class Events {
	
	@NotBlank
	@Size(min=6, max=12)
	private String eventCode;
	
	@NotBlank
	@Size(min=1, max=25)
	private String description;
	
	@NotNull(message="Must enter a number of days for the event")
	private int days;
	
	
	@NotNull
	@DateTimeFormat
	private Date date;
	
	private String email;
	
	private Events event;
	
	private List<Pictures> picture;
	
	
	
	// default constructor
	public Events(){}
	
	// constructor that takes in arguments code, description, days, date
	public Events(String eventCode, String description, int days, Date date, List<Pictures> picture) {
		super();
		this.eventCode = eventCode;
		this.description = description;
		this.days = days;
		this.date = date;
		this.picture = picture;
	}


	
	// get method for event
	public Events getEvent() {
		return event;
	}
	
	// set method for event
	public void setEvent(Events event) {
		this.event = event;
	}

	// get method for code
	public String getEventCode() {
		return eventCode;
	}
	
	// set method for code
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
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

	// get method for pictures
	public List<Pictures> getPicture() {
		return picture;
	}

	// set method for pictures
	public void setPicture(List<Pictures> picture) {
		this.picture = picture;
	}
	
}
