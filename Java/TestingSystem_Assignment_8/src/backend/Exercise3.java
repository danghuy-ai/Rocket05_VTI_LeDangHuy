package backend;

import java.util.List;

public class Exercise3 {
	
	//Question2
	public <T> void print(T a) {
		System.out.println(a);
	}
	
	
	//Question4
	public <T> void printArray(List<T> listInt) {
		System.out.println("Các số trong array là: ");
		for(int i=0; i<listInt.size(); i++) {
			System.out.print(listInt.get(i) + "  ");
		}
		System.out.println("");
	}
	
	
}
