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
public class UsersDao {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}



	public List<Users> getUsers(){
		
		String q = "Select * from accounts where username= 'jesse.jeun@drake.edu';";
		
		return jdbc.query(q, new RowMapper<Users>(){

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users users = new Users();
				
				users.setUsername(rs.getString("username"));
				users.setFirstName(rs.getString("firstName"));
				users.setLastName(rs.getString("lastName"));
				users.setEmail(rs.getString("userEmail"));
				users.setPassword(rs.getString("password"));
				users.setAddress(rs.getString("address"));
				users.setCity(rs.getString("city"));
				users.setState(rs.getString("state"));
				users.setZipcode(rs.getInt("zipcode"));
				users.setTelephone(rs.getString("telephone"));
				
				return users;
			}
			
		});
	}
}
