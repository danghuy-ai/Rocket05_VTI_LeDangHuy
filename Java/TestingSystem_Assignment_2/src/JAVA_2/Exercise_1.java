package JAVA_2;

import java.util.Date;

public class Exercise_1 {

	public static void main(String[] args) {
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
		
		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		group1.accs = acc1;
		group1.createDate = new Date("2020/07/20");
		
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Tam chuyen";
		group2.accs = acc1;
		group2.createDate = new Date("2020/07/20");
		
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Dev System";
		group3.accs = acc2;
		group3.createDate = new Date("2020/07/20");
		
		// create GroupAccount
		GroupAccount groupAcc2 = new GroupAccount();
		Group[] groupOfAccount2 = { group1, group2 };
		groupAcc2.groups = groupOfAccount2;
		groupAcc2.accs = acc2;
		groupAcc2.joinDate = new Date("2020/07/22");
		
		
		//Question 1
		if(acc2.departments == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		}
		else {
			System.out.println("Phòng ban của nhân viên này là: "+acc2.departments.departmentName);
		}
		
		//Question 2
		if(groupAcc2.accs.accID == acc2.accID && groupAcc2.groups.length == 0) {
			System.out.println("Nhan vien nay chua co group");
		}
		else if(groupAcc2.groups.length == 1) {
			System.out.println("Group của nhân viên này là: " + groupAcc2.groups[0].name);
		}
		else if(groupAcc2.groups.length == 2) {
			System.out.println("Group của nhân viên này là: " + groupAcc2.groups[0].name + " và "+ groupAcc2.groups[1].name);
		}
		else if(groupAcc2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		}
		else{
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		
		
		//Question 3
		System.out.println(acc2.departments == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là: "+acc2.departments.departmentName);
	
		
		//Question 4
		System.out.println(acc1.positions.positionName == PositionName.DEV ? "Đây là Developer" : "Người này không phải là Developer");

		
		//Question 5
		
		
		
		
		
		//Question 6
		int slGroup = groupAcc2.groups.length;
		switch (slGroup) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
			System.out.println("Group của nhân viên này là: " + groupAcc2.groups[0].name);
			break;
		case 2:
			System.out.println("Group của nhân viên này là: " + groupAcc2.groups[0].name + " và " + groupAcc2.groups[0].name);
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		
		
		//Question 7
		switch(acc1.positions.positionName) {
		case DEV:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
		}
		
		//Question 8
		System.out.println("\n--Question 8--");
		Account[] accs = { acc1, acc2 };
		for(Account acc : accs) {
			System.out.println("Email: "+acc.email);
			System.out.println("Full Name: "+acc.fullName);
			System.out.println("Phòng ban: "+acc.departments.departmentName);
		}
		
		
		//Question 9
		System.out.println("\n--Question 9--");
		Department[] departments = { department1, department2, department3 };
		for(Department department : departments) {
			System.out.println("ID: "+department.departmentID);
			System.out.println("Name: "+department.departmentName);
		}
		
		
		//Question 10
		System.out.println("\n--Question 10--");
		for(int i = 0; i < accs.length; i++) {
			System.out.println("Thông tin account thứ "+ (i+1) +" là:");
			System.out.println("Email: "+accs[i].email);
			System.out.println("Full Name: "+accs[i].fullName);
			System.out.println("Phòng ban: "+accs[i].departments.departmentName);
		}
		
		
		//Question 11
		System.out.println("\n--Question 11--");
		for(int i = 0; i < departments.length; i++) {
			System.out.println("Thông tin department thứ "+ (i+1) +" là:");
			System.out.println("ID: "+departments[i].departmentID);
			System.out.println("Name: "+departments[i].departmentName);
		}
		
		
		//Question 12
		System.out.println("\n--Question 12--");
		for(int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ "+ (i+1) +" là:");
			System.out.println("ID: "+departments[i].departmentID);
			System.out.println("Name: "+departments[i].departmentName);
		}
		
		
		//Question 13
		System.out.println("\n--Question 13--");
		for(int i = 0; i < accs.length; i++) {
			if(i != 1) {
				System.out.println("Thông tin account thứ "+ (i+1) +" là:");
				System.out.println("Email: "+accs[i].email);
				System.out.println("Full Name: "+accs[i].fullName);
				System.out.println("Phòng ban: "+accs[i].departments.departmentName);
			}
		}
		
		
		//Question 14
		System.out.println("\n--Question 14--");
		for(int i = 0; i < accs.length; i++) {
			if(accs[i].accID < 4) {
				System.out.println("Thông tin account thứ "+ (i+1) +" là:");
				System.out.println("Email: "+accs[i].email);
				System.out.println("Full Name: "+accs[i].fullName);
				System.out.println("Phòng ban: "+accs[i].departments.departmentName);
			}
		}
		
		
		//Question 15
		System.out.println("\n--Question 15--");
		for(int i = 1; i <= 20 ; i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
		
		
		//Question 16
		System.out.println("\n--Question 16--");
		int i = 0;
		while( i < accs.length) {
			System.out.println("Thông tin account thứ "+ (i+1) +" là:");
			System.out.println("Email: "+accs[i].email);
			System.out.println("Full Name: "+accs[i].fullName);
			System.out.println("Phòng ban: "+accs[i].departments.departmentName);
			i++;
		}
		i = 0;
		System.out.println("-----------------------------------");
		while(i < departments.length) {
			System.out.println("Thông tin department thứ "+ (i+1) +" là:");
			System.out.println("ID: "+departments[i].departmentID);
			System.out.println("Name: "+departments[i].departmentName);
			i++;
		}
		i = 0;
		System.out.println("-----------------------------------");
		while(i < 2) {
			System.out.println("Thông tin department thứ "+ (i+1) +" là:");
			System.out.println("ID: "+departments[i].departmentID);
			System.out.println("Name: "+departments[i].departmentName);
			i++;
		}
		i = 0;
		System.out.println("-----------------------------------");
		while(i < accs.length) {
			if(i != 1) {
				System.out.println("Thông tin account thứ "+ (i+1) +" là:");
				System.out.println("Email: "+accs[i].email);
				System.out.println("Full Name: "+accs[i].fullName);
				System.out.println("Phòng ban: "+accs[i].departments.departmentName);
				i++;
			}
		}
		i = 0;
		System.out.println("-----------------------------------");
		while(i < accs.length) {
			if(accs[i].accID < 4) {
				System.out.println("Thông tin account thứ "+ (i+1) +" là:");
				System.out.println("Email: "+accs[i].email);
				System.out.println("Full Name: "+accs[i].fullName);
				System.out.println("Phòng ban: "+accs[i].departments.departmentName);
				i++;
			}
		}
		i = 1;
		System.out.println("-----------------------------------");
		while(i <= 20) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
