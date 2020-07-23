package JAVA_2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise_3 {

	public static void main(String[] args) {
		// create department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Marketing";
		
		// create position
		Position position1 = new Position();
		position1.positionID = 1;
		position1.positionName = PositionName.DEV;
		
		// create account
		Account acc1 = new Account();
		acc1.accID = 1;
		acc1.email = "haidang29productions@gmail.com";
		acc1.userName = "dangblack";
		acc1.fullName = "Nguyen Hai Dang";
		acc1.departments = department1;
		acc1.positions = position1;
		acc1.createDate = new Date("2020/07/10");
		// create CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.id = 1;
		cate1.name = "Java";
		
		//create exam
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "VTIQ001";
		exam1.title = "Đề thi Java";
		exam1.categorys = cate1;
		exam1.duration = 60;
		exam1.accs = acc1;
		exam1.createDate = new Date("2020/07/10");
		
		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "VTIQ002";
		exam2.title = "Đề thi ADO.NET";
		exam2.categorys = cate1;
		exam2.duration = 180;
		exam2.accs = acc1;
		exam2.createDate = new Date("2020/07/11");
		
		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "VTIQ003";
		exam3.title = "Đề thi Python";
		exam3.categorys = cate1;
		exam3.duration = 120;
		exam3.accs = acc1;
		exam3.createDate = new Date("2020/07/12");
		
		//Question 1
		System.out.println("--Question 1--");
		Locale locale = new Locale("vi", "VN");

		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);

		String date = dateformat.format(exam1.createDate);

		System.out.println("Thông tin Exam thứ 1");
		System.out.println("ID: "+exam1.id);
		System.out.println("Code: "+exam1.code);
		System.out.println("Title: "+exam1.title);
		System.out.println("Category: "+exam1.categorys.name);
		System.out.println("Duration: "+exam1.duration);
		System.out.println("Creator: "+exam1.accs.userName);
		System.out.println("Create Date: "+date);
		
		
		//Question 2
		System.out.println("\n--Question 2--");
		String pattern = "yyyy-MM-dd-HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Exam[] exams = { exam1, exam2, exam3 };
		for (Exam exam : exams) {
			date = simpleDateFormat.format(exam.createDate);
			System.out.println("ID: "+exam.id);
			System.out.println("Code: "+exam.code);
			System.out.println("Title: "+exam.title);
			System.out.println("Category: "+exam.categorys.name);
			System.out.println("Duration: "+exam.duration);
			System.out.println("Creator: "+exam.accs.userName);
			System.out.println("Create Date: "+date);
		}
		
		
		//Question 3
		String pattern1 = "yyyy";
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);
		System.out.println("\n--Question 3--");
		for (Exam exam : exams) {
			date = simpleDateFormat1.format(exam.createDate);
			System.out.println("Code: " + exam.code + " - Create Date: "+date);
		}
		
		
		//Question 4
		String pattern2 = "yyyy-MM";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		System.out.println("\n--Question 4--");
		for (Exam exam : exams) {
			date = simpleDateFormat2.format(exam.createDate);
			System.out.println("Code: " + exam.code + " - Create Date: "+date);
		}
		
		
		//Question 5
		String pattern3 = "MM-dd";
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
		System.out.println("\n--Question 5--");
		for (Exam exam : exams) {
			date = simpleDateFormat3.format(exam.createDate);
			System.out.println("Code: " + exam.code + " - Create Date: "+date);
		}
	}

}
