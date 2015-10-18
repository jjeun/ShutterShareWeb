package com.shuttershare.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuttershare.web.dao.Pictures;
import com.shuttershare.web.dao.PicturesDao;
import com.shuttershare.web.dao.Users;
import com.shuttershare.web.dao.UsersDao;

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
	public List<Pictures> getCurrent(){
		return picturesDao.getPictures();
	}

}
