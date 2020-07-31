package com.vti.entity;

public class Account {
	private String id;
	private String name;
	private int balance;
	
	public Account(String id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void credit(int amount) {
		this.balance = this.balance + amount;
	}
	
	public void debit(int amount) {
		this.balance = this.balance - amount;
	}
	
	public void tranferTo(Account account, int amount) {
		this.balance = this.balance - amount;
		account.setBalance(account.getBalance() + amount);
	}

	public String toString () {
		return this.id +" - "+this.name+" - "+this.balance;
	}
}
