package com.timmy.DbEntity;

import java.util.HashSet;
import java.util.Set;

public class Assistant {
	
	 private int aid;//辅导员主键
	 private String ano;//辅导员编号
	 private String sex;//性别
	// private String deptid;//所属院系主键号
	// private String deptname;//所属院系名
	 private String aname;
	 private Set<Student> students=new HashSet<Student>();
	 private Department department;
	 
	 
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	 
	 
	 
	 

}
