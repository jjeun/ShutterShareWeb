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

@Component
public class EventsDao {
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}



	public List<Events> getEvents(){
		
		String q = "Select * from events";
		
		return jdbc.query(q, new RowMapper<Events>(){

			@Override
			public Events mapRow(ResultSet rs, int rowNum) throws SQLException {
				Events events= new Events();
				
				events.setCode(rs.getString("eventCode"));
				events.setEmail(rs.getString("userEmail"));
				events.setDescription(rs.getString("description"));
				events.setDays(rs.getInt("days"));
				events.setDate(rs.getDate("date"));
				
				return events;
			}			
		});
	}
	
	
	public int createEvent(String code, String email, String description, Date date, int days){
		
		String q = "Insert into events(eventCode, userEmail, description, date, days)"
				+ "values (?,?,?,?,?);";
		
		return jdbc.update(q,code, email, description, date, days );
	}
}
