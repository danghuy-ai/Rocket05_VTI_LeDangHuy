package frontend;

import java.util.ArrayList;
import java.util.Locale;

import entity.HinhChuNhat;
import entity.HinhHoc;
import entity.HinhTron;

public class Program1 {

	public static void main(String[] args) {
		
		HinhHoc h1 = new HinhTron(3);
		h1.tinhChuVi();
		h1.tinhDienTich();
		
		HinhHoc h2 = new HinhTron(4);
		h2.tinhChuVi();
		h2.tinhDienTich();
		
		HinhHoc h3 = new HinhTron(5);
		h3.tinhChuVi();
		h3.tinhDienTich();
		
		HinhHoc h4 = new HinhChuNhat(7,5);
		h4.tinhChuVi();
		h4.tinhDienTich();
		
		HinhHoc h5 = new HinhChuNhat(5,2);
		h5.tinhChuVi();
		h5.tinhDienTich();
		
		HinhHoc h6 = new HinhChuNhat(5,3);
		
		
		
	}

}
