package com.chrisxie.hb_student_tracker.jdbcTester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

import org.hibernate.exception.JDBCConnectionException;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		
		String userID = "hbstudent";
		
		
		
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);
			
			String user;
			
			String password;
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, userID,"");
			
			System.out.println("Connection successful!!!");
			
		} catch (SQLException e) {
			// TODO: handle exception
		
			System.err.println(e);
			
		
		}
		
		
	}

}
