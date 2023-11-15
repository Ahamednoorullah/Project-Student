package com.chainsys.marklist.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
	
	private static String url = "jdbc:mysql://localhost:3306/chainsys";
	private static String user = "root";
	private static String password = "irfani";
	
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
}

public static Connection getConnection() {
	Connection con = null;
	try {
		con = DriverManager.getConnection(url,user,password);
	} catch (SQLException e) {
		System.out.println("Connection Failed");
		e.printStackTrace();
	}
	return con;
}

}
