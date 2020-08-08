package entity;

import java.util.Comparator;

public class SortByName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		int value = o1.getName().compareTo(o2.getName());
		
		return value;
	}

}
