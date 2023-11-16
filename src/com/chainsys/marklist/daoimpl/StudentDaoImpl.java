package com.chainsys.marklist.daoimpl;
import com.chainsys.marklist.model.Student;
import com.chainsys.marklist.util.DbUtility;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chainsys.marklist.dao.StudentDAO;


public class StudentDaoImpl implements StudentDAO {
	

//	@Override
//	public boolean validation(int sid,String sname,double sperc) {
//	
//		System.out.println(sid);
////		Pattern p = Pattern.compile("^[a-zA-Z]*$");
////		Matcher m = p.matcher(sname);
//		if (sid > 0 && (sname.matches("^[a-zA-Z]*$"))&& (sname != null) &&(!sname.equals(" "))&& sperc > 0) {
//			return true;
//		} else {
//            return false;
//		}
//	
//	}

	@Override
	public void insertStudent(int sid, String sname, double sperc) throws SQLException {
         
		String query = "insert into studentmarklist values("+sid+",'"+sname+"',"+sperc+")";
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();
		
		int nor1 = stmt.executeUpdate(query);
		
		if (nor1 == 1) {
			System.out.println("Student Added successfully...");
		} else {
            System.out.println("Something Went Wrong..");
		}
	}

	
	@Override
	public void deleteStudent(int sid) throws SQLException {
		String query = "delete from studentmarklist where sid="+sid;
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();
		
		int nor1 = stmt.executeUpdate(query);
		
		if (nor1 == 1) {
			System.out.println("Student Deleted Successfully..");
		} else {
			System.out.println("This Id is Not in StudentList..");
		}
		
	}

	@Override
	public void listofStudent() throws SQLException {
		String query = "select sname from studentmarklist";
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();
		
		ResultSet rs =  stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
	}

	@Override
	public List<Student> displayAll() throws SQLException {
		List<Student> list= new ArrayList<>();
		String query = "select * from studentmarklist";
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		
		while (rs.next()) {
			list.add(new Student(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
		}
		return list;
	}

	@Override
	public int saveStudent(Student student) throws SQLException {
		String query = "insert into studentmarklist values("+student.getSid()+",'"+student.getSname()+"',"+student.getSperc()+")";
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();
		
		int nor1 = stmt.executeUpdate(query);
		if (nor1==1) {
			return 1;
		} else {
			return 0;

		}
		
	}


	@Override
	public int updateStudent(Student student ) throws SQLException {
		String query = "update studentmarklist set sname='"+student.getSname()+"',sperc="+student.getSperc()+" where sid ="+student.getSid();
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();
		int noru = stmt.executeUpdate(query);
		if (noru==1) {
			return 1;
		} else {
            return 0;
		}
	}


	
	

}
