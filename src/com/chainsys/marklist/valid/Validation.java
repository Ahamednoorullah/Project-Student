package com.chainsys.marklist.valid;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.marklist.dao.StudentDAO;
import com.chainsys.marklist.daoimpl.StudentDaoImpl;
import com.chainsys.marklist.main.StudentTest;
import com.chainsys.marklist.model.Student;

public class Validation extends Student{

	private int sid;
	private String sname;
	private double sperc;
	private int sub1;
	private int sub2;
	private int sub3;

	public Validation(int sid,String sname,double sperc) {
		
		this.sid = sid;
		this.sname = sname;
		this.sperc = sperc;
	}
	public Validation(int sub1,int sub2,int sub3,int sid) {
		this.sub1=sub1;
		this.sub1=sub1;
		this.sub1=sub1;
		this.sid=sid;
		
	}

	public int getSid() {
		return sid;
	}

	public void setSid() {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname() {
		this.sname = sname;
	}

	public double getSperc() {
		return sperc;
	}

	public void setSperc() {
		this.sperc = sperc;
	}

	public boolean markValid() {
		if ((sub1>=0 && sub1<=100) && (sub2>=0 && sub2<=100) && (sub3>=0 && sub3<=100)) {
			return true;
		} else {
            return false;
		}
	}
	public boolean getValid() {
		if (sid > 0 && (sname.matches("^[a-zA-Z]*$")) && (sname != null) && (!sname.equals(" ")) && (sperc > 0) ) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getDBValid() throws SQLException {
		StudentDAO dao = new StudentDaoImpl();
		List<Student> li = dao.displayAll();
		for (Student studentList : li) {
			if (sid == studentList.getSid()) {
				return true;
			}

		}
		return false;

	}
}
