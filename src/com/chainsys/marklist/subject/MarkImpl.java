package com.chainsys.marklist.subject;

import com.chainsys.marklist.model.Student;
import com.chainsys.marklist.main.StudentTest;
import com.chainsys.marklist.util.DbUtility;
import com.chainsys.marklist.valid.Validation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.marklist.daoimpl.StudentDaoImpl;

public class MarkImpl extends StudentMark {
	Student student = new Student();
	StudentMark sm = new StudentMark();

	public void insertMark(int sid, int sub1, int sub2, int sub3,double percentage) throws SQLException {
		String query = "insert into studentmark values(" + sid + "," + sub1 + "," + sub2 + "," + sub3 + ","+percentage+")";
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();

		int nori = stmt.executeUpdate(query);

		if (nori == 1) {
			System.out.println("Subject Mark Added");
		} else {
			System.out.println("Something Went Wrong..");
		}
	}

	public List<StudentMark> displayMark() throws SQLException {
		List<StudentMark> list = new ArrayList<>();
		String query = "select sid,sub1,sub2,sub3,percentage from studentmark";
		Connection con = DbUtility.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			list.add(new StudentMark(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),rs.getDouble(5)));
		}

		return list;

	}
}
