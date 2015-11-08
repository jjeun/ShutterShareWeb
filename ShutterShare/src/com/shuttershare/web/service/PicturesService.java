package com.shuttershare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuttershare.web.dao.Pictures;
import com.shuttershare.web.dao.PicturesDao;


/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: PicturesService class - handles service calls to the database

*/


@Service("picturesService")
public class PicturesService {
	
	private PicturesDao picturesDao; // declaring object usersDao of type UsersDao
	
	// setPicturesDao() method that utilizes Spring Autowired annotation
	// Has argument that passes PicutresDao object which is injected automatically
	// by Spring. The argument is initialized within the method to the picturesDao object 
	// called earlier in this class. 
	@Autowired
	public void setPicturesDao(PicturesDao picturesDao) {
		this.picturesDao = picturesDao;
	}


	// getCurrent() method that returns a List of type Users which is retrieved by 
	// the method getPictures of the object picturesDao.
	public List<Pictures> getPictures(String eventCode){
		return picturesDao.getPictures(eventCode);
	}


	// deletePic method that service the deletePic method of PicturesDao which deletes a photo from the database
	public Boolean deletePic(String picture) {
		
		return picturesDao.deletePic(picture);
		
	}

}
