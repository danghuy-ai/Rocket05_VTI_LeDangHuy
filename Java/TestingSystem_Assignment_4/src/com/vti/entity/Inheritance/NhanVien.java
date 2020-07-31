package com.vti.entity.Inheritance;

import java.util.Scanner;

public class NhanVien extends CanBo{
	private String congViec;

	@Override
	public void  inputCanBo() {
		super.inputCanBo();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap vao cong viec: ");
		this.congViec = scanner.nextLine();
	}
	
	@Override
	public void thongTin() {
		super.thongTin();
		System.out.println("Cong viec	: " + this.congViec);
	}
}
