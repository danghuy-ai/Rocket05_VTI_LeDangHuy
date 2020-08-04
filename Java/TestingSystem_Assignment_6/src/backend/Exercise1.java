package backend;

import java.util.Scanner;

public class Exercise1 {
	private static Scanner scanner = new Scanner(System.in);
	
	public int inputAge(){
		System.out.println("Moi nhap vao 1 so: ");
		String tuoi = scanner.next();
		
		try
	    {
			int age = Integer.parseInt(tuoi.trim());
	      
		  	if(age>=0) {
				return age;
			}
			else {
				System.err.println("Wrong inputing! The age must be greater than 0, please input again.");
				return 0;
			}
				
	    } catch (NumberFormatException e)
	    {
	    	System.err.println("wrong inputing! Please input an age as int, input again.");
	    	return 0;
	    }
		
	}
	
	public int inputAge_Q6(){
		while (true) {
			System.out.println("Moi nhap vao 1 so: ");
			String tuoi = scanner.next();
			
			try
		    {
				int age = Integer.parseInt(tuoi.trim());
		      
			  	if(age>=0) {
					return age;
				}
				else
					System.err.println("Wrong inputing! The age must be greater than 0, please input again.");
		    }
		    catch (NumberFormatException e)
		    {
		    	System.err.println("wrong inputing! Please input an age as int, input again.");
		    }
		}
		
	}
}
