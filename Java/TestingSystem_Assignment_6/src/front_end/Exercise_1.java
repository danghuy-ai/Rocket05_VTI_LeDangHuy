package front_end;

import java.util.Scanner;

import backend.Exercise1;
import backend.ScannerUtils;
import entity.Department;

public class Exercise_1 {

	public static void main(String[] args) {
		//Question 5
		Exercise1 exe1 = new Exercise1();
		System.out.println(exe1.inputAge()); 
		
		//Question 6
		System.out.println(exe1.inputAge_Q6()); 
	
		//Question 7
		System.out.println("Nhập id: ");
		int id = ScannerUtils.inputInt("ID phải là 1 số dương, nhập lại: ");
		System.out.println("ID vừa nhập: " + id);
		
		//Question 9
		Department dep = new Department();
		System.out.println(dep.toString());
	}

}
