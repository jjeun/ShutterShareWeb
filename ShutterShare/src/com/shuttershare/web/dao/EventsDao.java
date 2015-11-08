package com.shuttershare.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: Events Dao class - handles all the sql querying for events

*/


// class EventsDao that handles all sql queries for Events. Utilizes SpringFramework Component class
@Component
public class EventsDao {
	
	// declaring private variable jdbc of type Jdbc Template
	private JdbcTemplate jdbc;
	
	
	// method that will connect jdbc to the database. Utilizes Springframework Autowired annotation
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}


	// get method getEvents that returns a list of event from sql query. 
	public List<Events> getEvents(String username){
		
		String q = "Select * from events where userEmail='"+ username +"'";
		
		return jdbc.query(q, new RowMapper<Events>(){

			@Override
			public Events mapRow(ResultSet rs, int rowNum) throws SQLException {
				Events events= new Events();
				
				events.setEventCode(rs.getString("eventCode"));
				events.setEmail(rs.getString("userEmail"));
				events.setDescription(rs.getString("description"));
				events.setDays(rs.getInt("days"));
				events.setDate(rs.getDate("date"));
				
				return events;
			}			
		});
	}
	
	
	// method that createEvent that creates a new event and returns an integer value  0 or 1.
	public int createEvent(String eventCode, String email, String description, Date date, int days){
		
		String q = "Insert into events(eventCode, userEmail, description, date, days)"
				+ "values (?,?,?,?,?);";
		
		return jdbc.update(q, eventCode, email, description, date, days );
	}


	// method deletEvent that will delete and events. Utilizes Springframework Transactional annotation
	// that will create an exception if any of the queries in the method should fail. 
	@Transactional
	public boolean deletEvent(String eCode) {
	
		int count = 0;
		
		String q = "Select Count(eventCode) from pictures where eventCode='"+eCode+"';";
		count = jdbc.queryForObject(q,Integer.class);  // calling 
		
		// condition that executes in the count is greater than 0. Indicates that the event has pictures. 
		if(count > 0){
			
			q = "Delete from events where eventCode='"+eCode+"';";		
			jdbc.update(q);  // query that will delete events where eventCode == eCode
			
			q = "Delete from pictures where eventCode='"+eCode+"';";	
			return jdbc.update(q)==1;  // query that will delete pictures where eventCode == eCode
		}
		
		q = "Delete from events where eventCode='"+eCode+"';";		
		return jdbc.update(q)==1;   // query that will delete events where eventCode == eCode
	}
}
