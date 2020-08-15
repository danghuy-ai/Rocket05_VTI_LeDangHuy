package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise1 {
	
	//Question 2
	public static void Question2() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/testingsystem";
		String username = "root";
		String pass = "123456";
		
		Connection myConn = DriverManager.getConnection(dbUrl, username, pass);
		System.out.println("Connect success!");
		
		Statement state = myConn.createStatement();
		
		String query = "SELECT * FROM position";
		ResultSet set = state.executeQuery(query);
		while(set.next()) {
			System.out.println(set.getInt("PositionID") + " " + set.getString("PositionName"));
		}
		
		myConn.close();
	}
}
