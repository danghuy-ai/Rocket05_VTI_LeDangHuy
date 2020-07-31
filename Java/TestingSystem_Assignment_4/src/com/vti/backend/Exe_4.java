package com.vti.backend;

import com.vti.entity.Student;
import com.vti.entity.Account;
import com.vti.entity.Date;

public class Exe_4 {
	public void Question1() {
		Student[] students = new Student[5];
		Student stu1 = new Student(1, "Huy", "Hanoi");
		Student stu2 = new Student(2, "Manh", "Bac Ninh");
		Student stu3 = new Student(3, "Thang", "Hanoi");
		Student stu4 = new Student(4, "Quang", "Thai Binh");
		Student stu5 = new Student(5, "Thinh", "Quang Ninh");
		
		students[0] = stu1;
		students[1] = stu2;
		students[2] = stu3;
		students[3] = stu4;
		students[4] = stu5;
		
		stu1.setMark(7);
		stu2.setMark(7.5f);
		stu3.setMark(5.25f);
		stu4.setMark(4.5f);
		
		stu1.setMarkPlus(1.75f);
		stu3.setMarkPlus(0.75f);
		
		for(Student student : students){
			System.out.println(student.inThongTin()); 
		}
	}
	
	public void Question2() {
		Account[] accounts = new Account[3];
		Account acc1 = new Account("A01","Huy",250000);
		Account acc2 = new Account("A02","Luc",150000);
		Account acc3 = new Account("A03","Minh",1000000);
		accounts[0] = acc1;
		accounts[1] = acc2;
		accounts[2] = acc3;
		for(Account account : accounts){
			System.out.println(account.toString()); 
		}
		acc1.tranferTo(acc2, 50000);
		
		for(Account account : accounts){
			System.out.println(account.toString()); 
		}
		
		Date date = new Date(20,2,2020);
		System.out.println(date.isLeapYear());
	}
}
