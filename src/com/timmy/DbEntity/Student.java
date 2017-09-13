package com.timmy.DbEntity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	
	private int sid;//表中学生主键
	private String sno;//学号
	private String sname;//学生姓名
	private String sex;
	//private int deptid;//院系主键
//	private String deptname;//院系名字
	private String major;//主修课程
	private String classname;//班级名称
	//private int aid;//辅导员主键
	//private String asstname;//辅导员姓名
	private Assistant assistant;
	private Department department;
	private Set<StudentCheckingIn> studentCheckingIns=new HashSet<StudentCheckingIn>();
	
	
	public Set<StudentCheckingIn> getStudentCheckingIns() {
		return studentCheckingIns;
	}
	public void setStudentCheckingIns(Set<StudentCheckingIn> studentCheckingIns) {
		this.studentCheckingIns = studentCheckingIns;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Assistant getAssistant() {
		return assistant;
	}
	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
