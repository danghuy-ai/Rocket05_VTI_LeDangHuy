package Ass_3;

import java.util.Date;

public class Exercise_2 {

	public static void main(String[] args) {
		Question1();
	}
	
	static void Question1() {
		Account[] accounts = new Account[5];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account();
			accounts[i].email = "Email " + (i+1);
			accounts[i].userName = "User name " + (i+1);
			accounts[i].fullName = "Full name " + (i+1);
			accounts[i].createDate = new Date();
		}
		
		for (Account account : accounts) {
			System.out.println(account.email +", "+ account.userName +", "+ account.fullName +", "+ account.createDate);
		}
	}

}
