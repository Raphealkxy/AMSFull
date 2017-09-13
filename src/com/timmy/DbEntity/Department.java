package com.timmy.DbEntity;

import java.util.HashSet;
import java.util.Set;

public class Department {
	
	private int deptid;//院系主键
	private String deptnum;//院系编号
	private String deptname;//院系名称
	private Set<Teacher>teachers=new HashSet<Teacher>();
	
	private Set<Student>students=new HashSet<Student>();
	private Set<Assistant>assistants=new HashSet<Assistant>();
	
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptnum() {
		return deptnum;
	}
	public void setDeptnum(String deptnum) {
		this.deptnum = deptnum;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Assistant> getAssistants() {
		return assistants;
	}
	public void setAssistants(Set<Assistant> assistants) {
		this.assistants = assistants;
	}
	
	

}
