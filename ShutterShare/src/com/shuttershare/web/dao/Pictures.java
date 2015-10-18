package com.shuttershare.web.dao;

import java.util.Date;

public class Pictures {
	
	private int picId;
	private String code;
	private String uploader;
	private Date date;
	private String picture;
	
	
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
	
	
	

}
