package com.vti.entity.Abstraction;

public class VietnamesePhone extends Phone {

	@Override
	public void insertContact(String name, String phone) {
		super.Phone(phone, name);
	}

	@Override
	public void removeContact(String name) {
		boolean xoa = false;
		for(int i = 0; i<super.getContacts().size(); i++) {
			if(super.getContacts().get(i).contains(name)) {
				super.getContacts().remove(i);
				i--;
				xoa = true;
			}
		}
		if(!xoa) {
			System.out.println("Khong co contact ten " + name);
		}
		else {
			System.out.println("Xoa thanh cong");
		}
	}

	@Override
	public void updateContact(String name, String newPhone) {
		boolean capNhat = false;
		for(int i = 0; i<super.getContacts().size(); i++) {
			if(super.getContacts().get(i).contains(name)) {
				super.getContacts().set(i, name + " - " + newPhone);
				capNhat = true;
			}
		}
		if(!capNhat) {
			System.out.println("Khong co contact ten " + name);
		}
		else {
			System.out.println("Cap nhat thanh cong");
		}
	}

	@Override
	public void searchContact(String name) {
		boolean search = false;
		for(int i = 0; i<super.getContacts().size(); i++) {
			if(super.getContacts().get(i).contains(name)) {
				System.out.println("Thong tin tra ve: " + super.getContacts().get(i)); 
				search = true;
			}
		}
		if(!search) {
			System.out.println("Khong co contact ten " + name);
		}
	}
	
	public void info() {
		super.inThongTin();
	}
}
