package JAVA_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Exercise_5 {

	public static void main(String[] args) throws ParseException {
		// Question 1
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap vao 3 so nguyen tuy chon: ");
		if (scanner.hasNextInt()) {
			int x1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int x3 = scanner.nextInt();
			System.out.println("3 so vua nhap la: " + x1 + ", "+ x2 + ", "+ x3);
		}
		else
			System.out.println("Nhap sai dinh dang so nguyen!");
		
		
		// Question 2
		System.out.println("Nhap vao 2 so thuc tuy chon: ");
		if (scanner.hasNextFloat()) {
			float x1 = scanner.nextFloat();
			float x2 = scanner.nextFloat();
			System.out.println("2 so thuc vua nhap la: " + x1 + ", "+ x2 );
		}
		else
			System.out.println("Nhap sai dinh dang so thuc!");
		
		
		// Question 3
		System.out.println("Nhap vao ho va ten: ");
		String ho = scanner.next();
		String ten = scanner.next();
		System.out.println("Ho ten cua ban la: " + ho + " "+ ten );
		
		
		// Question 4
		System.out.println("Nhap vao ngay sinh theo dinh dang day-month-year: ");
		String dateInput = scanner.next();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateInput);
		System.out.println("Ngay sinh nhat cua ban la: " + date );
		
		
		// Question 5
		createAccount();
		
		
		// Question 6
		createDepartment();
		
		
		// Question 7
		System.out.println("Nhap vao 1 so chan");
		int soChan = scanner.nextInt();
		if (soChan > 0 && soChan % 2 == 0) {
			System.out.println("So chan vua nhap la: " + soChan);
		} else {
			System.out.println("Day khong phai la so chan!");
		}
		
		
		// Question 8
		while(true) {
			System.out.println("**************************************************");
			System.out.println("**          Chương trình quản lý                **");
			System.out.println("**       1. Thực hiện tạo account               **");
			System.out.println("**       2. Thực hiện tạo department            **");
			System.out.println("**       0. Thoát                               **");
			System.out.println("**************************************************");
			System.out.println("**   Mời bạn nhập vào chức năng muốn sử dụng: ");
			
			if(scanner.hasNextInt()) {
			int luaChon = scanner.nextInt();
			switch (luaChon) {
			case 1:
				createAccount();
				break;
			case 2:
				createDepartment();
				break;
			case 0:
				return;
			default:
				System.out.println("Mời bạn nhập lại!");
	            break;
			}
			}
			else {
				System.out.println("Nhập số thôi ba?? Chạy lại dùm!");
				return;
			}
		}
		
		
		// Question 9
		createGroupAccount();
		
		
		// Question 10
		
		
		
		// Question 11
		
		
	}
	static void createAccount() throws ParseException {
		Position position1 = new Position();
		position1.positionID = 1;
		position1.positionName = PositionName.DEV;
		
		Position position2 = new Position();
		position2.positionID = 2;
		position2.positionName = PositionName.TEST;
		
		Position position3 = new Position();
		position3.positionID = 3;
		position3.positionName = PositionName.SCRUM_MASTER;
		
		Position position4 = new Position();
		position4.positionID = 4;
		position4.positionName = PositionName.PM;
		
		Account acc = new Account();
		
		Scanner scanner1 = new Scanner(System.in);

		System.out.print("Nhap vao Account ID:");
		byte id = scanner1.nextByte();

		scanner1.nextLine();
		System.out.print("Nhap vao username:");
		String userName = scanner1.nextLine();

		System.out.print("Nhap vao Position ID (tu 1 -> 4):");
		int position = scanner1.nextInt(6);
		switch (position) {
		case 1:
			acc.positions = position1;
			break;
		case 2:
			acc.positions = position2;
			break;
		case 3:
			acc.positions = position3;
			break;
		case 4:
			acc.positions = position4;
			break;
		default:
			System.out.print("Khong ton tai Position ID nay!");
		}

		System.out.println("Ngay tao theo dinh dang day-month-year: ");
		String dateInput = scanner1.next();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateInput);
		
		acc.accID = id;
		acc.userName = userName;
		acc.createDate = date;
		
		System.out.println("Thông tin Account vừa tạo: ");
		System.out.println("ID: "+acc.accID);
		System.out.println("Username: "+acc.userName);
		System.out.println("Position Name: "+acc.positions.positionName);
		System.out.println("Create Date: "+acc.createDate);
	}
	
	static void createDepartment() {
		Department department1 = new Department();
		
		Scanner scanner1 = new Scanner(System.in);

		System.out.print("Nhap vao Department ID:");
		byte id = scanner1.nextByte();
		
		scanner1.nextLine();
		System.out.print("Nhap vao Department Name:");
		String name = scanner1.nextLine();
		
		department1.departmentID = id;
		department1.departmentName = name;
		
		System.out.println("--Thông tin phòng ban vừa tạo--");
		System.out.println("ID: " + department1.departmentID);
		System.out.println("Name: " + department1.departmentName);
	}
	
	static void createGroupAccount() {
		Scanner scanner = new Scanner(System.in);
		
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
		
		Account acc3 = new Account();
		acc3.accID = 3;
		acc3.email = "ledanghuy@gmail.com";
		acc3.userName = "danghuy";
		acc3.fullName = "Le Dang Huy";
		acc3.departments = department3;
		acc3.positions = position2;
		acc3.createDate = new Date("2020/07/07");
		
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
		GroupAccount groupAcc = new GroupAccount();
		
		Account[] accs = { acc1, acc2, acc3 };
		Group[] groups = { group1, group2, group3 };
		
		System.out.println("--Danh sách các userNames Account--");
		for(Account acc : accs) {
			System.out.println(acc.userName);
		}
		System.out.println("Nhập username muốn thêm vào group: ");
		String ho = scanner.next();
		
		switch (ho) {
		case "dangblack":
			groupAcc.accs = acc1;
			break;
		case "tungnui":
			groupAcc.accs = acc2;
			break;
		case "danghuy":
			groupAcc.accs = acc3;
			break;
		default:
			System.out.println("Mời bạn nhập lại tên username đã có!");
            return;
		}
		
		System.out.println("--Danh sách các group--");
		for(Group group : groups) {
			System.out.println(group.name);
		}
		scanner.nextLine();
		System.out.println("Nhập tên group muốn thêm vào: ");
		String name = scanner.nextLine();
		
		Group[] groupOfAccount = { };
		
		switch (name) {
		case "Testing System":
			groupOfAccount = insert(groupOfAccount, group1);
			groupAcc.groups = groupOfAccount;
			break;
		case "Tam chuyen":
			groupOfAccount = insert(groupOfAccount, group2);
			groupAcc.groups = groupOfAccount;
			break;
		case "Dev System":
			groupOfAccount = insert(groupOfAccount, group3);
			groupAcc.groups = groupOfAccount;
			break;
		default:
			System.out.println("Mời bạn nhập lại tên group đã có!");
            return;
		}
		groupAcc.joinDate = new Date();
		
		System.out.println("User được thêm vào group thành công!");
		System.out.println("Usernam: " + groupAcc.accs.userName);
		System.out.println("Group: " + groupAcc.groups[0].name);
		System.out.println("Date join: " + groupAcc.joinDate);
		
	}
	private static Group[] insert(Group[] groupOfAccount, Group group1) {
		 int arrIndex = groupOfAccount.length - 1;
        int tempIndex = groupOfAccount.length;
        Group [] tempArr = new Group [tempIndex + 1];
        boolean inserted = false;
         
        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1) {
                tempArr[i] = groupOfAccount[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = group1;
                    inserted = true;
                } else {
                    tempArr[i] = groupOfAccount[arrIndex--];
                }
            }
        }
        return tempArr;
	}
}
