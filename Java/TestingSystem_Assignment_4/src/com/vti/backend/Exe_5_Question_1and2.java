package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Inheritance.CanBo;
import com.vti.entity.Inheritance.CongNhan;
import com.vti.entity.Inheritance.KySu;
import com.vti.entity.Inheritance.NhanVien;

public class Exe_5_Question_1and2 {
	private ArrayList<CanBo> canBo;
	
	public Exe_5_Question_1and2() {
		canBo = new ArrayList<CanBo>();
	}
	
	public void addCanBo() {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		System.out.println("Nhap so luong can bo muon them moi: ");
		n = scanner.nextInt();
		
		CanBo canBoNew = new CanBo();
		int chon = 0;
		for(int i=0; i<n; i++) {
			System.out.println("Chon loai can bo muon them (1-Cong nhan; 2-Ky su; 3-Nhan vien): ");
			chon = scanner.nextInt();
			switch (chon){
			case 1:
				canBoNew = new CongNhan();
				canBoNew.inputCanBo();
				canBo.add(canBoNew);
				break;
			case 2:
				canBoNew = new KySu();
				canBoNew.inputCanBo();
				canBo.add(canBoNew);
				break;
			case 3:
				canBoNew = new NhanVien();
				canBoNew.inputCanBo();
				canBo.add(canBoNew);
				break;
			default:
				System.out.println("Nhap sai. Lua chon lai loai can bo co san!!");
				i--;
				break;
			}
			
		}
	}
	
	public void inDS() {
		for(CanBo person : canBo) {
			person.thongTin();
		}
	}
	
	public void timCanBo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho ten can bo muon tim kiem: ");
		String hoTen = scanner.nextLine();
		
		int ketQua=0;
		for(CanBo person : canBo) {
			if(person.getHoTen().equals(hoTen)) {
				ketQua++;
				person.thongTin();
			}
		}
		System.out.println(ketQua+" ket qua tra ve!");
	}
	
	public void xoaCanBo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho ten can bo muon xoa: ");
		String hoTen = scanner.nextLine();
		
		canBo.removeIf(cb -> hoTen.equals(cb.getHoTen()));
	}
}
