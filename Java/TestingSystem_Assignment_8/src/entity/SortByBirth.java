package entity;

import java.util.Comparator;

public class SortByBirth implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int value = 0;
		
		if(o1.getBirthDay().isBefore(o2.getBirthDay())) {
			value = -1;
		}
		else if(o1.getBirthDay().isAfter(o2.getBirthDay())) {
			value = 1;
		}
		else {
			Comparator<Student> sortByMark = new SortByMark();
			value = sortByMark.compare(o1, o2);
		}
			
		
		return value;
	}

}
