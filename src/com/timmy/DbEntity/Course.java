package com.timmy.DbEntity;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private int cid;
	//private int tid;
	private Set<Teacher>teachers=new HashSet<Teacher>();
	//private String tname;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	

}
