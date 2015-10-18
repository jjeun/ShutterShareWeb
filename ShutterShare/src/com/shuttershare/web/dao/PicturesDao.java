package com.shuttershare.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PicturesDao {

private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}



	public List<Pictures> getPictures(){
		
		String q = "Select * from pictures";
		
		return jdbc.query(q, new RowMapper<Pictures>(){

			@Override
			public Pictures mapRow(ResultSet rs, int rowNum) throws SQLException {
				Pictures pictures= new Pictures();
				
				pictures.setCode(rs.getString("eventCode"));
				pictures.setUploader(rs.getString("uploader"));
				pictures.setPicId(rs.getInt("picId"));
				pictures.setDate(rs.getDate("date"));
				pictures.setPicture(rs.getString("picture"));
				
				return pictures;
			}			
		});
	}

}
