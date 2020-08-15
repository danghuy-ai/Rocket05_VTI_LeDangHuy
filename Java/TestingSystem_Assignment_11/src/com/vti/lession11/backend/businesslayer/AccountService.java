package com.vti.lession11.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.lession11.backend.datalayer.AccountRepository;
import com.vti.lession11.backend.datalayer.IAccountRepository;
import com.vti.lession11.entity.Account;

public class AccountService implements IAccountService{

	private IAccountRepository accountRepository;

	public AccountService() {
		accountRepository = new AccountRepository();
	}
	
	@Override
	public List<Account> getListAccounts() throws SQLException {
		return accountRepository.getListAccounts();
	}

	@Override
	public void createAccount(String email, String username, String fullname, int departmentID, int positionID, String date) throws SQLException {
		accountRepository.createAccount(email, username, fullname, departmentID, positionID, date);
	}

	@Override
	public Account getAccountByID(int id) throws SQLException {
		return accountRepository.getAccountByID(id);
	}

	@Override
	public boolean isAccountExists(String username) throws SQLException {
		return accountRepository.isAccountExists(username);
	}

	@Override
	public boolean isAccountExists(int id) throws SQLException {
		return accountRepository.isAccountExists(id);
	}

	@Override
	public void updateAccountByID(String email, int id) throws SQLException {
		accountRepository.updateAccountByID(email, id);
	}

	@Override
	public void deleteAccount(int id) throws SQLException {
		accountRepository.deleteAccount(id);
	}
}
