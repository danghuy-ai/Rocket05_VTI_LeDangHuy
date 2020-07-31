package com.vti.entity.Inheritance;

import java.util.Scanner;

public class KySu extends CanBo{
	private String ngangDT;

	@Override
	public void inputCanBo() {
		super.inputCanBo();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap vao nganh dao tao: ");
		this.ngangDT = scanner.nextLine();
	}
	
	@Override
	public void thongTin() {
		super.thongTin();
		System.out.println("Nganh dao tao	: " + this.ngangDT);
	}
}
