package com.shuttershare.web.dao;

import java.sql.Date;

/*
Author: Jesse Jeun
Date: 10/12/2015
CS188: Software Engineering - Professor Urness
Description: Pictures class 

*/



// Java Bean Picuters
public class Pictures {
	
	private int picId;
	private String code;
	private String uploader;
	private Date date;
	private String picture;
	private Pictures pictures;
	
	
	// default constructor
	public Pictures(){}
	
	// get method for picId
	public int getPicId() {
		return picId;
	}
	
	// set method for picId
	public void setPicId(int picId) {
		this.picId = picId;
	}
	
	// get method for code
	public String getCode() {
		return code;
	}
	
	// set method for code
	public void setCode(String code) {
		this.code = code;
	}
	
	// get method for uploader
	public String getUploader() {
		return uploader;
	}
	
	// set method for uploader
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	
	// get method for date
	public Date getDate() {
		return date;
	}
	
	// set method for date
	public void setDate(Date date) {
		this.date = date;
	}
	
	// get method for picture
	public String getPicture() {
		return picture;
	}
	
	// set method for picture
	public void setPicture(String picture) {
		this.picture = picture;
	}

	// get method for pictures object
	public Pictures getPictures() {
		return pictures;
	}
	
	// set method for pictures object
	public void setPictures(Pictures pictures) {
		this.pictures = pictures;
	}
	
	
}
