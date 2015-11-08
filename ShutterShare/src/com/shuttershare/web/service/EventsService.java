package com.shuttershare.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuttershare.web.dao.Events;
import com.shuttershare.web.dao.EventsDao;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: EventsService class  -  handles service calls to the database

*/


@Service("eventsService")
public class EventsService {
	
	private EventsDao eventsDao; // declaring object eventsDao of type EventsDao

	
	// setEventsDao() method that utilizes Spring Autowired annotation
	// Has argument that passes EventssDao object which is injected automatically
	// by Spring. The argument is initialized within the method to the eventsDao object 
	// called earlier in this class. 
	@Autowired
	public void setEventsDao(EventsDao eventsDao) {
		this.eventsDao = eventsDao;
	}


	// getCurrent() method that returns a List of type Events which is retrieved by 
	// the method getEvents of the object eventsDao.
	public List<Events> getCurrent(String username){
		return eventsDao.getEvents(username);
	}
	
	
	// createEvent method that services the createEvent method of EventsDao which creates a new event
	public void createEvent(String code, String email, String description, Date date, int days){
		
		eventsDao.createEvent(code, email, description, date, days);
	}


	// deleteEvent method that services the deleteEvent method of EventsDao that deletes a event
	public void deleteEvent(String eCode) {
		
		eventsDao.deletEvent(eCode);
		
	}

}
