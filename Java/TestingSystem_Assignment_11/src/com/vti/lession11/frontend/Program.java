package com.vti.lession11.frontend;

import java.sql.SQLException;
import java.util.List;

import com.vti.lession11.backend.presentationlayer.AccountController;
import com.vti.lession11.entity.Account;
import com.vti.lession11.utils.ScannerUtils;

public class Program {
	
	private static AccountController accountController;

	public static void main(String[] args) throws SQLException {
		accountController = new AccountController();
		
		getListAccounts();
		
		createAccount();
		
		getAccountByID();
		
		AccountExistsByUsername();
		
		AccountExistsByID();
		
		updateEmailById();
		
		deleteAccount();
		
	}
	
	private static void getListAccounts() throws SQLException {
		List<Account> accounts = accountController.getListAccounts();
		for (Account account : accounts) {
			System.out.println(account.toString());
		}
	}
	
	private static void createAccount() throws SQLException {
		String email, username, fullname, date;
		int departmentID, positionID;
		System.out.println("Nhập thông tin Account tạo mới");
		System.out.println("Email: ");
		email = ScannerUtils.inputString("Mới nhập lại!");
		System.out.println("Username: ");
		username = ScannerUtils.inputString("Mới nhập lại!");
		System.out.println("Full name: ");
		fullname = ScannerUtils.inputString("Mới nhập lại!");
		System.out.println("Department ID: ");
		departmentID = ScannerUtils.inputInt("Mới nhập vào 1 số!");
		System.out.println("Position ID: ");
		positionID = ScannerUtils.inputInt("Mới nhập vào 1 số!");
		System.out.println("CreateDate: ");
		date = ScannerUtils.convertLocalDateTimeToString(ScannerUtils.inputLocalDateTime());
		
		accountController.createAccount(email, username, fullname, departmentID, positionID, date);
	}
	
	private static void getAccountByID() throws SQLException {
		System.out.println("Nhập ID Account muốn tìm: ");
		int id = ScannerUtils.inputInt("Mới nhập vào 1 số!");
		
		Account account = accountController.getAccountByID(id);
		System.out.println(account.toString());
	}
	
	private static void AccountExistsByUsername() throws SQLException {
		
		System.out.println("Nhập userName Account muốn kiểm tra: ");
		String username = ScannerUtils.inputString("Mới nhập lại!");
		boolean check = accountController.isAccountExists(username);
		
		if(check) {
			System.out.println("userName: " + username + " có tồn tại!");
		}
		else
			System.out.println("userName: " + username + " không tồn tại!");
	}
	
	private static void AccountExistsByID() throws SQLException {
		
		System.out.println("Nhập ID Account muốn kiểm tra: ");
		int id = ScannerUtils.inputInt("Mới nhập vào 1 số!");
		boolean check = accountController.isAccountExists(id);
		
		if(check) {
			System.out.println("ID Account: " + id + " có tồn tại!");
		}
		else
			System.out.println("ID Account: " + id + " không tồn tại!");
	}
	
	private static void updateEmailById() throws SQLException {
		System.out.println("Nhập ID Account muốn cập nhật: ");
		int id = ScannerUtils.inputInt("Mới nhập vào 1 số!");
		System.out.println("Nhập email mới: ");
		String email = ScannerUtils.inputString("Mới nhập lại!");
		
		accountController.updateAccountByID(email, id);
	}
	
	private static void deleteAccount() throws SQLException {
		System.out.println("Nhập ID Account cần xóa: ");
		int id = ScannerUtils.inputInt("Mới nhập vào 1 số!");
		
		accountController.deleteAccount(id);
	}
}
