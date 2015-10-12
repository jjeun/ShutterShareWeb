package com.shuttershare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuttershare.web.dao.Users;
import com.shuttershare.web.dao.UsersDao;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: UsersService class 

*/

// start of class UsersService utilizes Spring Service annotation
@Service("usersService")
public class UsersService {
	
	private UsersDao usersDao; // declaring object usersDao of type UsersDao
	
	// setUsersDao() method that utilizes Spring Autowired annotation
	// Has argument that passes UsersDao object which is injected automatically
	// by Spring. The argument is initialized within the method to the usersDao object 
	// called earlier in this class. 
	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}


	// getCurrent() method that returns a List of type Users which is retrieved by 
	// the method getUsers of the object usersDao.
	public List<Users> getCurrent(){
		return usersDao.getUsers();
	}
	
}
