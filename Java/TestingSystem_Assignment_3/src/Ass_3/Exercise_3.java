package Ass_3;

public class Exercise_3 {

	public static void main(String[] args) {
		//Question 1
		Question1();
		
		//Question 2
		Question2();
		
		//Question 3
		Question3();
		
	}
	static void Question1() {
		Integer luong = new Integer(5000);
		
		float x = luong.floatValue();
		System.out.printf("Luong: %.2f %n",x);
	}
	
	static void Question2() {
		String x = "1234567";
		int y = Integer.parseInt(x);
		System.out.printf("String: %s %n",y);
	}
	
	static void Question3() {
		Integer a = new Integer(1234567);
		
		int b = a.intValue();
		System.out.printf("Int: %d %n",b);
	}
}
