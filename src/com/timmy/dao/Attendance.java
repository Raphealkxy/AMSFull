package com.timmy.dao;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Attendance {
	private int Aid;
	private Date date;
	private int isArrival;
	private String username;
	private String Coursename;
    private String userNumber;
    
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getCoursename() {
		return Coursename;
	}
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAid() {
		return Aid;
	}
	public void setAid(int aid) {
		Aid = aid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIsArrival() {
		return isArrival;
	}
	public void setIsArrival(int isArrival) {
		this.isArrival = isArrival;
	}

	
	

}
