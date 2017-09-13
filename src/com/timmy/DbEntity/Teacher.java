package com.timmy.DbEntity;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	
	private int tid;//老师主键
	private  String tno;//老师编号
	private String tname;//老师姓名
	private String tsex;//老师性别
	//private int deptid;//所在学院主键
	//private String deptname;//所在学院名字
	private String position;//教师职称
	private Department department;
	private Set<Course>courses=new HashSet<Course>();
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	

}
