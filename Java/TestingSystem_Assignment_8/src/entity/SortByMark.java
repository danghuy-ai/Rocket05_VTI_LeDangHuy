package entity;

import java.util.Comparator;

public class SortByMark implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int value = 0;
		
		if(o1.getMark() < o2.getMark()) {
			value = 1;
		}
		else if(o1.getMark() > o2.getMark()) {
			value = -1;
		}
		else
			value = 0;
		
		return value;
	}

}
