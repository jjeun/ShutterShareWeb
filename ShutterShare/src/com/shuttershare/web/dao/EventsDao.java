package com.shuttershare.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventsDao {
	private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbcNamed;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
		this.jdbcNamed = new NamedParameterJdbcTemplate(jdbc);
	}



	public List<Events> getEvents(){
		
		String q = "Select * from events";
		
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
	
	
	public int createEvent(String eventCode, String email, String description, Date date, int days){
		
		String q = "Insert into events(eventCode, userEmail, description, date, days)"
				+ "values (?,?,?,?,?);";
		
		return jdbc.update(q, eventCode, email, description, date, days );
	}


	@Transactional
	public boolean deletEvent(String eCode) {
	
		int count = 0;
		
		String q = "Select Count(eventCode) from pictures where eventCode='"+eCode+"';";
		count = jdbc.queryForObject(q,Integer.class);
		
		
		if(count > 0){
			
			q = "Delete from events where eventCode='"+eCode+"';";		
			jdbc.update(q);
			
			q = "Delete from pictures where eventCode='"+eCode+"';";	
			return jdbc.update(q)==1;
		}
		
		q = "Delete from events where eventCode='"+eCode+"';";		
		return jdbc.update(q)==1;
	}
}
