package com.timmy.DbEntity;

import java.util.HashSet;
import java.util.Set;
  
public class StudentCheckingIn {
	
	 private int scid;//考勤主键
//	 private String sno;//学工号
//	 private String sname;//学生姓名
	 private Set<Student>students=new HashSet<Student>();
	 private String style;//考勤类型
//	 private int aid;//辅导员主键
//	 private String  aname;//辅导员姓名
	 private String recordtime;//记录时间
	 
	 private String begintime;//开始时间
	 private String  endtime;//结束时间
	 public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	 
	                              
	

}
