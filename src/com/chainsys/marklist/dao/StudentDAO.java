package com.chainsys.marklist.dao;
import java.sql.SQLException;
import java.util.List;

import com.chainsys.marklist.model.Student;

public interface StudentDAO {

	void insertStudent(int sid,String sname,double sperc) throws SQLException;
	public int updateStudent(Student student) throws SQLException;
	public int saveStudent(Student student) throws SQLException;
	void deleteStudent(int sid) throws SQLException;
	public void listofStudent() throws SQLException;
	public List<Student> displayAll() throws SQLException;
	//public boolean validation(int i, String string, double d);
	//public boolean dbValidation(int i) throws SQLException;


}
