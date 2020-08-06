package IOStream.entity;

import java.io.Serializable;

import IOStream.ScannerUtils;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;

	public Student() {
		this.id = inputID();
		this.name = inputName();
	}

	private int inputID() {
		System.out.println("Nhập vào ID: ");
		int id = ScannerUtils.inputInt("ID phải là 1 số dương, nhập lại: ");
		return id;
	}

	private String inputName() {
		System.out.println("Nhập vào tên học sinh: ");
		String name = ScannerUtils.inputString("Chưa nhập tên học sinh, nhập lại: ");
		return name;
	}
	
	public String toString() {
		return "ID: " + this.id + " - Họ tên: " + this.name;
	}
}
