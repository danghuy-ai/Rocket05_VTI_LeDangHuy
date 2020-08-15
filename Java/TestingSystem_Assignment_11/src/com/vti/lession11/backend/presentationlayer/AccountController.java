package com.vti.lession11.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.lession11.backend.businesslayer.AccountService;
import com.vti.lession11.backend.businesslayer.IAccountService;
import com.vti.lession11.entity.Account;

/**
 * @author ledan
 *
 */
public class AccountController {
	private IAccountService accountService;

	public AccountController() {
		accountService = new AccountService();
	}

	public List<Account> getListAccounts() throws SQLException {
		
		return accountService.getListAccounts();
	}
	
	public void createAccount(String email, String username, String fullname, int departmentID, int positionID, String date) throws SQLException {
		
		if(isAccountExists(username)) {
			throw new SQLException("UserName is already exists");
		}
		accountService.createAccount(email, username, fullname, departmentID, positionID, date);
	}
	
	public Account getAccountByID(int id) throws SQLException {
		
		if(!isAccountExists(id)) {
			throw new SQLException("ID Account is not exists!");
		}
		return accountService.getAccountByID(id);
	}
	
	public boolean isAccountExists(String username) throws SQLException {
		
		return accountService.isAccountExists(username);
	}
	
	public boolean isAccountExists(int id) throws SQLException {
		
		return accountService.isAccountExists(id);
	}
	
	public void updateAccountByID(String email, int id) throws SQLException {
		
		if(!isAccountExists(id)) {
			throw new SQLException("ID Account is not exists!");
		}
		accountService.updateAccountByID(email, id);
	}
	
	public void deleteAccount(int id) throws SQLException {
		
		if(!isAccountExists(id)) {
			throw new SQLException("ID Account is not exists!");
		}
		accountService.deleteAccount(id);
	}
}
