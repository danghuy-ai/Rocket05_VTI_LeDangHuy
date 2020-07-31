package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String homeTown;
	private float mark;
	
	public Student(int id, String name, String homeTown) {
		super();
		this.id = id;
		this.name = name;
		this.homeTown = homeTown;
		this.mark = 0f;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}
	
	public void setMarkPlus(float mark) {
		this.mark += mark;
	}
	
	public float getMark() {
		return this.mark;
	}
	
	public String inThongTin() {
		String xeploai;
		if(mark <= 4) {
			xeploai="Yeu";
		}
		else if(mark>4 && mark<6)
			xeploai = "Trung binh";
		else if(mark>=6 && mark<8)
			xeploai = "Kha";
		else
			xeploai = "Gioi";
		
		return "Sinh vien: " + this.name + " - Diem: " + this.mark + 
				" - Xep loai hoc luc: " + xeploai;
		
		
	}
}
