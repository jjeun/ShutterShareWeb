package com.shuttershare.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: UsersService class 

*/


//class UsersDao that handles all sql queries for Users. Utilizes SpringFramework Component class
@Component
public class UsersDao {
	
	// declaring private variable jdbc of type Jdbc Template
	private JdbcTemplate jdbc;
	
	// declaring private variable jdbcNamed of type NamedParameterJdbc Template
	private NamedParameterJdbcTemplate jdbcNamed;
	
	// method that will connecting both templates to the database. Utilizes Springframework Autowired annotation
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
		this.jdbcNamed = new NamedParameterJdbcTemplate(jdbc);
	}


	// method getUsers that queries the database and returns a list of User objects
	public List<Users> getUsers(String username){
		
		String q = "Select * from accounts where username= '"+username+"';";
		
		return jdbc.query(q, new RowMapper<Users>(){

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users users = new Users();
				
				users.setUsername(rs.getString("username"));
				users.setFirstName(rs.getString("firstName"));
				users.setLastName(rs.getString("lastName"));
				users.setUserEmail(rs.getString("userEmail"));
				users.setPassword(rs.getString("password"));
				users.setAddress(rs.getString("address"));
				users.setCity(rs.getString("city"));
				users.setState(rs.getString("state"));
				users.setZipcode(rs.getString("zipcode"));
				users.setTelephone(rs.getString("telephone"));
				
				return users;
			}
			
		});	
	}
		
	
	// Method createAccount that excutes several queries to create a new user account.
	// Utilizes SpringFramework Transactional annotation that will execute all the queries or none at all.  
	@Transactional
	public boolean createAccount(Users user){
			
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
			
		jdbcNamed.update("insert into accounts(userEmail, username, firstName, lastName, password, address, city, state, zipcode, telephone) "
				+ "values (:userEmail, :username, :firstName, :lastName, :password, :address, :city, :state, :zipcode, :telephone)", params);

		jdbcNamed.update("insert into users(username, password, enabled) values (:username,:password, :enabled)", params);

		return jdbcNamed.update("insert into authorities(username, authority) values (:username, :authority)", params) == 1;
		
	}


	// Method updateAccount that excutes several queries to update a user account.
	// Utilizes SpringFramework Transactional annotation that will execute all the queries or none at all.  
	@Transactional
	public boolean updateAccount(Users user) {
		
		String q1 = "UPDATE accounts SET firstName='"+ user.getFirstName()+"', lastName='"+ user.getLastName()+"',"
				+ "password='"+user.getPassword()+"', address='"+user.getAddress()+"', city='"+user.getCity()+"', state='"+user.getState()+"',"
						+ "zipcode='"+user.getZipcode()+"', telephone='"+user.getTelephone()+"'"
				+ " WHERE userEmail='"+user.getUserEmail()+"'";
		
		String q2 = "UPDATE users SET password='"+user.getPassword()+"' WHERE username='"+user.getUsername()+"'";
		
		jdbc.update(q1);	
		
		return jdbc.update(q2) == 1;
	}	
	
}
