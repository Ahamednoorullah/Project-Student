package com.chainsys.marklist.model;

public class Student {

	private int sid;
	private String sname;
	private double sperc;
	
	public Student() {
		
	}
	
	public Student(int sid,String sname,double sperc) {
		this.sid=sid;
		this.sname=sname;
		this.sperc=sperc;
	}
	
	public int getSid() {return sid;}
	public void setSid(int sid) {
		this.sid=sid;
	}
	
	public String getSname() {return sname;}
	public void setSname(String sname) {
		this.sname=sname;
	}
	
	public double getSperc() {return sperc;}
	public void setSperc(double sperc) {
		this.sperc=sperc;
	}
	
	public String toString() {
		return   sid + "\t" +sname +"\t" + sperc ;
	}
	
}
