package Ass_3;

import java.util.Random;
import java.util.Scanner;

public class Exercise_1 {

	public static void main(String[] args) {
		//Question 1
		Question1();
		
		//Question 2
		Question2();
		
		//Question 3
		Question3();
		
		//Question 4
		Question4();
	}
	
	static void Question1() {
		System.out.println("---Question 1---");
		float luong1 = 5240.5f;
		float luong2 = 10970.055f;
		System.out.println(luong1 + ", " + luong2);
		
		int luongAcc1 = (int)luong1;
		int luongAcc2 = (int)luong2;
		
		System.out.println(luongAcc1 + ", " + luongAcc2);
	}
	
	static void Question2() {
		System.out.println("\n---Question 2---");
		Random random = new Random();
		int c = random.nextInt(100000);
		System.out.println("Số ngẫu nhiên ban đầu: " + c);
		if (c < 10000) {
			String number = String.valueOf(c);
			String newNumber = number;
			for (int i = 0; i < (5 - number.length()); i++) {
				
				newNumber = "0" + newNumber;
			}
			System.out.println("Số ngẫu nhiên: " + newNumber);
		}
		else {
			String newNumber = String.valueOf(c);
			System.out.println("Số ngẫu nhiên: " + newNumber);
		}
	}

	static void Question3() {
		System.out.println("\n---Question 3---");
		Random random = new Random();
		int c = random.nextInt(100000);
		System.out.println("Số ngẫu nhiên ban đầu: " + c);
		if (c < 10000) {
			String number = String.valueOf(c);
			String newNumber = number;
			for (int i = 0; i < (5 - number.length()); i++) {
				
				newNumber = "0" + newNumber;
			}
			System.out.println("Số ngẫu nhiên: " + newNumber);
			System.out.println("2 số cuối là: " + newNumber.substring(3));
		}
		else {
			String newNumber = String.valueOf(c);
			System.out.println("Số ngẫu nhiên: " + newNumber);
			System.out.println("2 số cuối là: " + newNumber.substring(3));
		}
	}
	
	static void Question4() {
		System.out.println("\n---Question 4---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap vao 2 so nguyen a va b: ");
		if (scanner.hasNextInt()) {
			int x1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			float thuong = (float) x1/x2;
			System.out.printf("%nThuong 2 so nguyen %d và %d là: %.4f",x1,x2,thuong);
		}
		else
			System.out.println("Nhap sai dinh dang so nguyen!");
	}
}
