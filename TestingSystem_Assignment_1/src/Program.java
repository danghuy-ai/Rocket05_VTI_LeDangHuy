import java.util.Date;
/**
 * 
 * @author DongHyun
 *
 */
public class Program {

	public static void main(String[] args) {
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
		
		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		group1.accs = acc1;
		group1.createDate = new Date("2020/07/20");
		
		// create GroupAccount
		GroupAccount groupAcc1 = new GroupAccount();
		groupAcc1.groups = group1;
		groupAcc1.accs = acc2;
		groupAcc1.joinDate = new Date("2020/07/22");
		
		// create TypeQuestion
		TypeQuestion type1 = new TypeQuestion();
		type1.id = 1;
		type1.TypeName = TypeNameQuestion.ESSAY;
		
		TypeQuestion type2 = new TypeQuestion();
		type2.id = 2;
		type2.TypeName = TypeNameQuestion.MULTIPLE_CHOICE;
		
		// create CategoryQuestion
		CategoryQuestion cate1 = new CategoryQuestion();
		cate1.id = 1;
		cate1.name = "Java";
		
		CategoryQuestion cate2 = new CategoryQuestion();
		cate2.id = 2;
		cate2.name = "ADO.NET";
		
		CategoryQuestion cate3 = new CategoryQuestion();
		cate3.id = 2;
		cate3.name = "Python";
		
		//create Question
		Question ques1 = new Question();
		ques1.id = 1;
		ques1.content = "Câu hỏi về Java";
		ques1.categorys = cate1;
		ques1.types = type1;
		ques1.accs = acc1;
		ques1.createDate = new Date("2020/07/02");
		
		Question ques2 = new Question();
		ques2.id = 2;
		ques2.content = "Hỏi về ADO.NET";
		ques2.categorys = cate2;
		ques2.types = type2;
		ques2.accs = acc2;
		ques2.createDate = new Date("2020/07/05");
		
		Question ques3 = new Question();
		ques3.id = 3;
		ques3.content = "Hỏi về Python";
		ques3.categorys = cate3;
		ques3.types = type2;
		ques3.accs = acc1;
		ques3.createDate = new Date("2020/07/03");
		
		// create Answer
		Answer ans1 = new Answer();
		ans1.id = 1;
		ans1.content = "Trả lời 01";
		ans1.questions = ques1;
		ans1.isCorrect = false;
		
		Answer ans2 = new Answer();
		ans2.id = 2;
		ans2.content = "Trả lời 02";
		ans2.questions = ques1;
		ans2.isCorrect = true;
		
		Answer ans3 = new Answer();
		ans3.id = 3;
		ans3.content = "Trả lời 03";
		ans3.questions = ques3;
		ans3.isCorrect = false;
		
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
		exam2.categorys = cate2;
		exam2.duration = 180;
		exam2.accs = acc1;
		exam2.createDate = new Date("2020/07/11");
		
		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "VTIQ003";
		exam3.title = "Đề thi Python";
		exam3.categorys = cate3;
		exam3.duration = 120;
		exam3.accs = acc2;
		exam3.createDate = new Date("2020/07/12");
		
		// create ExamQuestion
		ExamQuestion examQ1 = new ExamQuestion();
		examQ1.exams = exam1;
		examQ1.questions = ques1;
		
		ExamQuestion examQ2 = new ExamQuestion();
		examQ2.exams = exam2;
		examQ2.questions = ques2;
		
		ExamQuestion examQ3 = new ExamQuestion();
		examQ3.exams = exam3;
		examQ3.questions = ques3;
		
		
		
		// print object
		System.out.println("Thông tin phòng ban: ");
		System.out.println("ID: " + department1.departmentID);
		System.out.println("Name: " + department1.departmentName);
		System.out.println("ID: " + department2.departmentID);
		System.out.println("Name: " + department2.departmentName);
		System.out.println("ID: " + department3.departmentID);
		System.out.println("Name: " + department3.departmentName);
		System.out.println("\n");
		
		System.out.println("Thông tin vị trí: ");
		System.out.println("ID: " + position1.positionID);
		System.out.println("Name: " + position1.positionName);
		System.out.println("ID: " + position2.positionID);
		System.out.println("Name: " + position2.positionName);
		System.out.println("ID: " + position3.positionID);
		System.out.println("Name: " + position3.positionName);
		System.out.println("\n");
		
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
		
		System.out.println("Thông tin Group: ");
		System.out.println("ID: "+group1.id);
		System.out.println("Name: "+group1.name);
		System.out.println("Creator: "+group1.accs.userName);
		System.out.println("Create Date: "+group1.createDate);
		System.out.println("\n");
		
		System.out.println("Thông tin Group Account: ");
		System.out.println("Group: "+groupAcc1.groups.name);
		System.out.println("Account: "+groupAcc1.accs.userName);
		System.out.println("Join Date: "+groupAcc1.joinDate);
		System.out.println("\n");
		
		System.out.println("Thông tin Type Question: ");
		System.out.println("ID: "+type1.id);
		System.out.println("Name: "+type1.TypeName);
		System.out.println("ID: "+type2.id);
		System.out.println("Name: "+type2.TypeName);
		System.out.println("\n");
		
		System.out.println("Thông tin Category Question: ");
		System.out.println("ID: "+cate1.id);
		System.out.println("Name: "+cate1.name);
		System.out.println("\n");
		
		System.out.println("Thông tin Question: ");
		System.out.println("ID: "+ques1.id);
		System.out.println("Content: "+ques1.content);
		System.out.println("Category: "+ques1.categorys.name);
		System.out.println("Type: "+ques1.types.TypeName);
		System.out.println("Creator: "+ques1.accs.userName);
		System.out.println("Create Date: "+ques1.createDate);
		System.out.println("\n");
		
		System.out.println("Thông tin Answer: ");
		System.out.println("ID: "+ans1.id);
		System.out.println("Content: "+ans1.content);
		System.out.println("Question: "+ans1.questions.content);
		System.out.println("isCorrect: "+ ans1.isCorrect);
		System.out.println("ID: "+ans2.id);
		System.out.println("Content: "+ans2.content);
		System.out.println("Question: "+ans2.questions.content);
		System.out.println("isCorrect: "+ ans2.isCorrect);
		System.out.println("\n");
		
		System.out.println("Thông tin Exam: ");
		System.out.println("ID: "+exam1.id);
		System.out.println("Code: "+exam1.code);
		System.out.println("Title: "+exam1.title);
		System.out.println("Category: "+exam1.categorys.name);
		System.out.println("Duration: "+exam1.duration);
		System.out.println("Creator: "+exam1.accs.userName);
		System.out.println("Create Date: "+exam1.createDate);
		System.out.println("\n");
		
		System.out.println("Thông tin Exam Question: ");
		System.out.println("Exam: "+examQ1.exams.code);
		System.out.println("Question: "+examQ1.questions.content);
		System.out.println("\n");
	}

}
