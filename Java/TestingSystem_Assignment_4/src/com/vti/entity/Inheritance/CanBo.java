package com.vti.entity.Inheritance;

import java.util.Scanner;

public class CanBo {
	private String hoTen;
	private int tuoi;
	private gioiTinh gioiTinh;
	private String diaChi;
	
	public void inputCanBo() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap ho ten: ");
		this.hoTen = scanner.nextLine();
		
		System.out.println("Nhap tuoi: ");
		this.tuoi = scanner.nextInt();
		
		System.out.println("Nhap gioi tinh (0-Nam ; 1-Nu ; anyNumber-Khac): ");
		int gender = scanner.nextInt();
		if(gender==0)
			this.gioiTinh = com.vti.entity.Inheritance.gioiTinh.NAM;
		else if(gender==1)
			this.gioiTinh = com.vti.entity.Inheritance.gioiTinh.NU;
		else
			this.gioiTinh = com.vti.entity.Inheritance.gioiTinh.KHAC;
		scanner.nextLine();
		System.out.println("Nhap dia chi: ");
		this.diaChi = scanner.nextLine();
	}

	public String getHoTen() {
		return hoTen;
	}
	
//	public boolean equals(String hoTen) {
//		if (this.hoTen.equals(hoTen)) {
//			return true;
//		}
//		else
//			return false;
//	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public void thongTin() {
		System.out.println("------------------");
		System.out.println("Ho ten		: " + this.hoTen);
		System.out.println("Tuoi		: " + this.tuoi);
		System.out.println("Gioi tinh	: " + this.gioiTinh);
		System.out.println("Dia chi		: " + this.diaChi);
	}
}
