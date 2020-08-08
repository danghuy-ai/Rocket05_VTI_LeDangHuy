package backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.SortByBirth;
import entity.SortByMark;
import entity.SortByName;
import entity.Student;
import utils.Utils;

public class Exercise2 {
	private static List<Student> students;
	
	public Exercise2(){
		students = new ArrayList<>();
	}
	
	public static List<Student> getStudents() {
		return students;
	}

	public static void setStudents(List<Student> students) {
		Exercise2.students = students;
	}
	
	
	public void Question1() {
		//Student s1 = new Student(1, "Huy", util.convertStringToLocalDate("07-07-1999") ,10f);
	
		students.add(new Student(1, "Huy", Utils.convertStringToLocalDate("07-07-1999") ,10f));
		students.add(new Student(2, "Minh", Utils.convertStringToLocalDate("20-11-1999") ,9.2f));
		students.add(new Student(3, "Tung", Utils.convertStringToLocalDate("05-04-1999") ,8.75f));
		students.add(new Student(4, "Anh", Utils.convertStringToLocalDate("07-11-1998") ,7.5f));
		students.add(new Student(5, "Anh", Utils.convertStringToLocalDate("10-05-1999") ,8.5f));
		students.add(new Student(6, "Huy", Utils.convertStringToLocalDate("07-05-1999") ,9f));
		students.add(new Student(7, "Huy", Utils.convertStringToLocalDate("07-10-1999") ,9f));
		students.add(new Student(8, "Huy", Utils.convertStringToLocalDate("07-05-1999") ,6.9f));
		students.add(new Student(9, "Huy", Utils.convertStringToLocalDate("07-05-1999") ,9f));
		students.add(new Student(10, "Huy", Utils.convertStringToLocalDate("07-05-1999") ,9.5f));
		students.add(new Student(11, "Huy", Utils.convertStringToLocalDate("07-05-1999") ,8.5f));
		
		
		Comparator<Student> sortByName = new SortByName();
		Comparator<Student> sortByBirth = new SortByBirth();
		Comparator<Student> sortByMark = new SortByMark();
		
		Collections.sort(students);
		Collections.sort(students, sortByName.thenComparing(sortByBirth.thenComparing(sortByMark)));
		
		for (Student student : students) {
			System.out.println(student.toString());
		}
		
		
	}


	
}
