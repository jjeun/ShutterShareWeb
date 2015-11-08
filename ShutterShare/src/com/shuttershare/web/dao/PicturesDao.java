package com.shuttershare.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: PicturesDao class - handles all the sql queries for pictures
*/



//class PicturesDao that handles all sql queries for Pictures. Utilizes SpringFramework Component class
@Component
public class PicturesDao {

	// declaring private variable jdbc of type Jdbc Template
	private JdbcTemplate jdbc;
	
	
	// method that will connect jdbc to the database. Utilizes Springframework Autowired annotation
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	
	// Method getPictures that will query the database and return and list of Picuture objects
	public List<Pictures> getPictures(String eventcode){
		
		String q = "Select * from pictures where eventCode='"+ eventcode +"'";
		
		return jdbc.query(q, new RowMapper<Pictures>(){

			@Override
			public Pictures mapRow(ResultSet rs, int rowNum) throws SQLException {
				Pictures pics= new Pictures();
				
				pics.setPicId(rs.getInt("picId"));
				pics.setCode(rs.getString("eventCode"));
				pics.setUploader(rs.getString("uploader"));
				pics.setDate(rs.getDate("date"));
				pics.setPicture(rs.getString("picture"));
				
				return pics;
			}			
		});
	}
	
	
	// Method deletePic that will delete a picture from the database.
	public boolean deletePic(String picture) {
		
			String q = "Delete from pictures where picture='"+picture+"';";	
			return jdbc.update(q)==1;
	}
}
