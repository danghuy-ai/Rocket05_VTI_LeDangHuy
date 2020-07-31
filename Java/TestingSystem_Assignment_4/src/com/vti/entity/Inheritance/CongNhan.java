package com.vti.entity.Inheritance;

import java.util.Scanner;

public class CongNhan extends CanBo {
	private byte capBac;
	
	@Override
	public void inputCanBo() {
		super.inputCanBo();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap vao cap bac (1-10): ");
		this.capBac = scanner.nextByte();
	}
	
	@Override
	public void thongTin() {
		super.thongTin();
		System.out.println("Cap bac		: " + this.capBac);
	}
}
