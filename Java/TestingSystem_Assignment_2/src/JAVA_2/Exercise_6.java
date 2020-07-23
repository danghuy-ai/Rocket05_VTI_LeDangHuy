package JAVA_2;

import java.util.Date;


public class Exercise_6 {

	public static void main(String[] args) {
		question1();
		
		question2();
		
		question3();
	}
	
	static void question1() {
		System.out.println("--Question 1--");
		for(int i = 1; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	static void question2() {
		// create department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Marketing";
		
		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Sale";
		
		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "Giam doc";
		
		// create position
		Position position1 = new Position();
		position1.positionID = 1;
		position1.positionName = PositionName.DEV;
		
		Position position2 = new Position();
		position2.positionID = 2;
		position2.positionName = PositionName.TEST;
		
		Position position3 = new Position();
		position3.positionID = 3;
		position3.positionName = PositionName.SCRUM_MASTER;
		
		// create account
		Account acc1 = new Account();
		acc1.accID = 1;
		acc1.email = "haidang29productions@gmail.com";
		acc1.userName = "dangblack";
		acc1.fullName = "Nguyen Hai Dang";
		acc1.departments = department1;
		acc1.positions = position1;
		acc1.createDate = new Date("2020/07/10");
		
		Account acc2 = new Account();
		acc2.accID = 2;
		acc2.email = "sontungmtp@gmail.com";
		acc2.userName = "tungnui";
		acc2.fullName = "Nguyen Thanh Tung";
		acc2.departments = department2;
		acc2.positions = position3;
		acc2.createDate = new Date("2020/07/05");
		
		System.out.println("\n--Question 2--");
		System.out.println("Thông tin Account: ");
		System.out.println("ID: "+acc1.accID);
		System.out.println("Email: "+acc1.email);
		System.out.println("Username: "+acc1.userName);
		System.out.println("Full Name: "+acc1.fullName);
		System.out.println("Department Name: "+acc1.departments.departmentName);
		System.out.println("Position Name: "+acc1.positions.positionName);
		System.out.println("Create Date: "+acc1.createDate);
		System.out.println("ID: "+acc2.accID);
		System.out.println("Email: "+acc2.email);
		System.out.println("Username: "+acc2.userName);
		System.out.println("Full Name: "+acc2.fullName);
		System.out.println("Department Name: "+acc2.departments.departmentName);
		System.out.println("Position Name: "+acc2.positions.positionName);
		System.out.println("Create Date: "+acc2.createDate);
		System.out.println("\n");
	}
	
	static void question3() {
		System.out.println("\n--Question 3--");
		for(int i = 1; i < 10; i++) {
			System.out.println(i);
		}
	}
}
