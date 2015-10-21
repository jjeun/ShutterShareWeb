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


@Component
public class UsersDao {
	
	private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbcNamed;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
		this.jdbcNamed = new NamedParameterJdbcTemplate(jdbc);
	}



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
		
	
	@Transactional
	public boolean createAccount(Users user){
			
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
			
		jdbcNamed.update("insert into accounts(userEmail, username, firstName, lastName, password, address, city, state, zipcode, telephone) "
				+ "values (:userEmail, :username, :firstName, :lastName, :password, :address, :city, :state, :zipcode, :telephone)", params);

		jdbcNamed.update("insert into users(username, password, enabled) values (:username,:password, :enabled)", params);

		return jdbcNamed.update("insert into authorities(username, authority) values (:username, :authority)", params) == 1;
		
	}	
}
