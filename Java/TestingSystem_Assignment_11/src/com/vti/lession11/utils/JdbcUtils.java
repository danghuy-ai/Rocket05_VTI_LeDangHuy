package com.vti.lession11.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/testingsystem";
	private static final String username = "root";
	private static final String pass = "123456";
	private Connection myConn;
	
	public static boolean isConnectedForTesting() throws SQLException {
		boolean test = false;
		
		DriverManager.getConnection(dbUrl, username, pass);
		System.out.println("Connect success!");
		test = true;
		
		return test;
	}
	
	public Connection getConnection() throws SQLException {
		if (myConn == null || myConn.isClosed()) {
			myConn = DriverManager.getConnection(dbUrl, username, pass);
		}
		
		return myConn;
	}
	
	public void disconnect() throws SQLException {
		if(myConn != null && !myConn.isClosed()) {
			myConn.close();
		}
	}
}
