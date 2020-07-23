package JAVA_2;

import java.util.Date;
import java.util.Locale;

public class Exercise_2 {

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
		
		//Question 1
		int x1 = 5;
		System.out.printf("%d %n",x1);
		
		//Question 2
		int x2 = 100000000;
		System.out.printf(Locale.US, "%,d %n",x2);
		
		//Question 3
		float x3 = 5.567098f;
		System.out.printf("%.4f %n",x3);
		
		//Question 4
		String hoTen = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân %n",hoTen);
		
		//Question 5
		Date date = new Date();
		System.out.printf("%1$td/%1$tm/%1$ty %tHh:%tMp:%tSs  %n", date, date, date);
		
		//Question 6
		Account[] accs = { acc1, acc2 };
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("|  Email                                    |         Full Name        |        Phong ban      |");
		for(Account acc : accs) {
			System.out.printf ("|%s        |        %s       |            %s         |%n", acc.email, acc.fullName, acc.departments.departmentName);
		}
		System.out.println("-------------------------------------------------------------------------------------------------------");
	}

}
