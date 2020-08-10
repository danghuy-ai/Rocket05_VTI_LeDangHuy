package front_end;

import entity.Student;

public class Program1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Student student1 = new Student("Nguyễn Văn A");
		Student student2 = new Student("Nguyễn Văn B");
		Student student3 = new Student("Nguyễn Văn C");
		
		System.out.println(student1.toString());
		System.out.println(student2.toString());
		System.out.println(student3.toString());
		
		System.out.println(student1.getId());
		System.out.println(student1.getIdStr());
	}

}
