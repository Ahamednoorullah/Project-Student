package com.chainsys.marklist.subject;

public class StudentMark {
	private int sub1;
	private int sub2;
	private int sub3;
	String sname;
	public StudentMark() {
		
	}
	
	public StudentMark(String sname,int sub1,int sub2,int sub3) {
		this.sub1=sub1;
		this.sub2=sub2;
		this.sub3=sub3;
	    this.sname=sname;
	}
	public int getSub1() {return sub1;}
	public void setSub1(int sub1) {
		this.sub1=sub1;
	}
	
	public int getSub2() {return sub2;}
	public void setSub2(int sub2) {
		this.sub2=sub2;
	}
	
	public int getSub3() {return sub3;}
	public void setSub3(int sub3) {
		this.sub3=sub3;
	}
	
	public String toString() {
		return sname+"\t"+sub1+"\t"+sub2+"\t"+sub3;
	}

}
