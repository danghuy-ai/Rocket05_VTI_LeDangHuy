package front_end;

import java.util.ArrayList;
import java.util.List;

import backend.Exercise3;
import entity.MyMap;
import entity.Student;
import utils.Utils;

public class Program3 {
	public static void main(String[] args) {
		
		Exercise3 exe3 = new Exercise3();
		
		//Question2
		exe3.print(new Student(1, "Huy", Utils.convertStringToLocalDate("07-07-1999") ,10f));
		exe3.print(4);
		exe3.print(4.5f);
		
		
		//Question4
		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(1);
		listInt.add(5);
		listInt.add(15);
		
		List<Float> listFloat = new ArrayList<Float>();
		listFloat.add(1.25f);
		listFloat.add(5f);
		listFloat.add(15.0f);
		
		List<Long> listLong = new ArrayList<Long>();
		listLong.add(1l);
		listLong.add(6l);
		listLong.add(16l);
		
		List<Double> listDouble = new ArrayList<Double>();
		listDouble.add(1.5d);
		listDouble.add(6.0d);
		listDouble.add(18d);
		
		System.out.println("\n_Dãy Integer_");
		exe3.printArray(listInt);
		System.out.println("\n_Dãy Float_");
		exe3.printArray(listFloat);
		System.out.println("\n_Dãy Long_");
		exe3.printArray(listLong);
		System.out.println("\n_Dãy Double_");
		exe3.printArray(listDouble);
		
		
		//Question6
		MyMap<Integer, String> students = new MyMap<Integer, String>();
		
		students.put(1, "Huy");
		students.put(3, "Minh");
		students.put(6, "Luc");
		
		System.out.println(students.getValue(3));
		
	}
}
