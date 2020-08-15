package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;

public class DepartmentDao {
	private static final String dbUrl = "jdbc:mysql://localhost:3306/testingsystem";
	private static final String username = "root";
	private static final String pass = "123456";
	
	//Question 1
	public static List<Department> getDepartments() throws SQLException {
		Connection myConn = DriverManager.getConnection(dbUrl, username, pass);
		System.out.println("Connect success!");
		
		List<Department> departments = new ArrayList<Department>();
		Statement state = myConn.createStatement();
		
		String query = "SELECT * FROM department ORDER BY DepartmentID";
		ResultSet set = state.executeQuery(query);
		
		while(set.next()) {
			int id = set.getInt(1);
			String name = set.getString(2);
			
			Department dep = new Department(id, name);
			departments.add(dep);
		}
		myConn.close();
		return departments;
	}
	
	
	//Question 2
	public static void getDepartmentByID(int id) throws SQLException {
		Connection myConn = DriverManager.getConnection(dbUrl, username, pass);
		System.out.println("Connect success!");
		
		String query = "SELECT * FROM department WHERE DepartmentID = ?";
		PreparedStatement ps = myConn.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet set = ps.executeQuery();
		
		if(set.next() == false) {
			System.out.println("Cannot find department which has id = " + id);
			return;
		}
		else
			System.out.println("Department: " + set.getInt(1) + " - " + set.getString(2));
		
		myConn.close();
	}
	
}
