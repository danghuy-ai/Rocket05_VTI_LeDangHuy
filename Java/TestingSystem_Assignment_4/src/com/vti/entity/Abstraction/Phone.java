package com.vti.entity.Abstraction;

import java.util.ArrayList;

public abstract class Phone {
	private ArrayList<String> contacts;
	private String number;
	private String name;

	public Phone() {
		contacts = new ArrayList<String>();
	}
	
	public void Phone(String number, String name) {
		this.number = number;
		this.name = name;
		contacts.add(name+ " - " + number);
	}

	public ArrayList<String> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<String> contacts) {
		this.contacts = contacts;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void inThongTin() {
		for (int i =0; i<this.contacts.size(); i++) {
			System.out.println(this.contacts.get(i));
		}
	}

	public abstract void insertContact(String name, String phone);
	
	public abstract void removeContact(String name);
	
	public abstract void updateContact(String name, String newPhone);
	
	public abstract void searchContact(String name);
	
}
