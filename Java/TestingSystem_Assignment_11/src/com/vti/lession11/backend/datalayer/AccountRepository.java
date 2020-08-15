package com.vti.lession11.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.lession11.entity.Account;
import com.vti.lession11.utils.JdbcUtils;

public class AccountRepository implements IAccountRepository {

	private JdbcUtils jdbcUtils;

	public AccountRepository() {
		jdbcUtils = new JdbcUtils();
	}
	
	@Override
	public List<Account> getListAccounts() throws SQLException {

		List<Account> accounts = new ArrayList<Account>();
		Connection myCon = jdbcUtils.getConnection();
		
		String query = "select Email, Username from account";
		Statement state = myCon.createStatement();
		ResultSet set = state.executeQuery(query);
		
		while(set.next()) {
			String email = set.getString("Email");
			String user = set.getString("Username");
			
			Account account = new Account(user,email);
			
			accounts.add(account);
		}
		myCon.close();
		return accounts;
	}
	
	@Override
	public void createAccount(String email, String username, String fullname, int departmentID, int positionID, String date) throws SQLException {
		
		Connection myCon = jdbcUtils.getConnection();
		String query = "insert into `account` (Email,Username,Fullname,DepartmentID,PositionID,CreateDate) "+
				"values (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = myCon.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, username);
		preparedStatement.setString(3, fullname);
		preparedStatement.setInt(4, departmentID);
		preparedStatement.setInt(5, positionID);
		preparedStatement.setString(6, date);
		
		int row = preparedStatement.executeUpdate();
		if (row > 0)
			System.out.println("Inserted "+row+" account successful!");
		else
			System.out.println("This account is already exists!");
		jdbcUtils.disconnect();
	}
	
	@Override
	public Account getAccountByID(int id) throws SQLException {
		Connection myCon = jdbcUtils.getConnection();
		String query = "select Email, Username from account where AccountID = ?";
		PreparedStatement preparedStatement = myCon.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet set = preparedStatement.executeQuery();
		
		if (set.next()) {
			String email = set.getString("Email");
			String user = set.getString("Username");
			
			Account account = new Account(user,email);
			jdbcUtils.disconnect();
			return account;
		}
		else {
			jdbcUtils.disconnect();
			throw new SQLException("ID Account is not exists!");
		}
	}

	@Override
	public boolean isAccountExists(String username) throws SQLException {
		Connection myCon = jdbcUtils.getConnection();
		String query = "select Email, Username from account where Username = ?";
		PreparedStatement preparedStatement = myCon.prepareStatement(query);
		preparedStatement.setString(1, username);
		
		ResultSet set = preparedStatement.executeQuery();
		boolean test = false;
		
		if(set.next()) {
			test = true;
		}
		jdbcUtils.disconnect();
		return test;
	}

	@Override
	public boolean isAccountExists(int id) throws SQLException {
		Connection myCon = jdbcUtils.getConnection();
		String query = "select Email, Username from account where AccountID = ?";
		PreparedStatement preparedStatement = myCon.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet set = preparedStatement.executeQuery();
		boolean test = false;
		
		if(set.next()) {
			test = true;
		}
		jdbcUtils.disconnect();
		return test;
	}

	@Override
	public void updateAccountByID(String email, int id) throws SQLException {
		Connection myCon = jdbcUtils.getConnection();
		String query = "update `account` set email = ? where AccountID = ?";
		PreparedStatement preparedStatement = myCon.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setInt(2, id);
		
		int row = preparedStatement.executeUpdate();
		if(row > 0) {
			System.out.println(">> "+row+" records is updated!");
		}
		else
			System.out.println(">> 0 records is updated!");
	}

	@Override
	public void deleteAccount(int id) throws SQLException {
		Connection myCon = jdbcUtils.getConnection();
		String query = "delete from `account` where AccountID = ?";
		PreparedStatement preparedStatement = myCon.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		int row = preparedStatement.executeUpdate();
		if(row > 0) {
			System.out.println(">> "+row+" records is deleted!");
		}
		else
			System.out.println(">> 0 records is deleted!");
	}
	
}
