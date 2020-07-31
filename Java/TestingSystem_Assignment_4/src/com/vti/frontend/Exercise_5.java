package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exe_5_Question_1and2;
import com.vti.entity.Inheritance.HighSchoolStudent;

public class Exercise_5 {

	public static void main(String[] args) {
		//Question 1+2
		Exe_5_Question_1and2 QLCB = new Exe_5_Question_1and2();
		byte chon;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("**********Quan ly can bo*********");
			System.out.println("**    1. Them moi can bo       **");
			System.out.println("**    2. Tim kiem theo ho ten  **");
			System.out.println("**    3. In danh sach can bo   **");
			System.out.println("**    4. Xoa can bo theo ten   **");
			System.out.println("**    0. Thoat                 **");
			System.out.println("**                             **");
			System.out.println("*********************************");
			System.out.println("**   Nhap lua chon cua ban     **");
			chon = scan.nextByte();
			switch(chon) {
			case 1:
				QLCB.addCanBo();
				break;
			case 2:
				QLCB.timCanBo();
				break;
			case 3:
				QLCB.inDS();
				break;
			case 4:
				QLCB.xoaCanBo();
				break;
			case 0:
				System.out.println("Da thoat huong trinh thanh cong!");
				break;
			default:
				System.out.println("Nhập sai. Nhập lại !");
				break;
			}
		}while(chon != 0);
		//scan.close();
		
		//Question 3
//		HighSchoolStudent newStudent = new HighSchoolStudent("Nam", 1, "Chuyên Văn", "Đại học công nghệ");
//		System.out.println(newStudent.toString()); 
		
		
		
		
		
		
	}

}
