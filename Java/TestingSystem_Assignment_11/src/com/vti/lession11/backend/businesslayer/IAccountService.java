/**
 * 
 */
package com.vti.lession11.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.lession11.entity.Account;

/**
 * @author ledan
 *
 */
public interface IAccountService {
	
	public void createAccount(String email, String username, String fullname, int departmentID, int positionID, String date) throws SQLException;

	public List<Account> getListAccounts() throws SQLException;

	public Account getAccountByID(int id) throws SQLException;

	public boolean isAccountExists(String username) throws SQLException;

	public boolean isAccountExists(int id) throws SQLException;

	public void updateAccountByID(String email, int id) throws SQLException;

	public void deleteAccount(int id) throws SQLException;
}
