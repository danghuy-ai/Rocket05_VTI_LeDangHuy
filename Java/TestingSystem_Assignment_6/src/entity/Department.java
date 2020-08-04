package entity;

import backend.ScannerUtils;

public class Department {
	int departmentID;
	String departmentName;
	
	public Department() {
		this.departmentID = inputID();
		this.departmentName = inputName();
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(byte departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	private int inputID() {
		System.out.println("Nhập vào ID: ");
		int id = ScannerUtils.inputInt("ID phải là 1 số dương, nhập lại: ");
		return id;
	}
	
	private String inputName() {
		System.out.println("Nhập vào tên phòng ban: ");
		String name = ScannerUtils.inputString("Chưa nhập tên phòng ban, nhập lại: ");
		return name;
	}
	
	public String toString() {
		return "Thông tin phòng ban ID: " + this.departmentID + " - Tên: " + this.departmentName;
	}
}
