package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import backend.Exercise2;
import utils.Utils;

public class Student implements Comparable<Student> {
	private int id;
	private String name;
	private LocalDate birthDay;
	private float mark;
	
	public Student(int id, String name, LocalDate birthDay, float mark) {
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}
	
	public String toString() {
		return "ID: " + this.id + " - Tên: " + this.name + " - Ngày sinh: " + Utils.convertLocalDateToString(this.birthDay) + " - Điểm: " + this.mark;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Student o) {
		 // So sánh 2 String.
        int value = this.name.compareTo(o.name);
 
//        // Nếu name của 2 đối tượng là không bằng nhau.
//        if (value != 0) {
//            return value;
//        }
//        
//		// Nếu name của 2 đối tượng là giống nhau
//        // Thì so sánh theo ngày sinh
//        Comparator sortByBirth = new SortByBirth();
//        value = sortByBirth.compare(this, o);
        
		return value;
	}
	
	
}
