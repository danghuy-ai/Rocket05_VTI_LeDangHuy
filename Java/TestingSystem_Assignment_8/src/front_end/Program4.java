package front_end;

import entity.MyMath;
import entity.MyNumber;

public class Program4 {

	public static void main(String[] args) {
		//Question 2
		MyNumber<Integer> num1 = new MyNumber<Integer>(2);
		MyNumber<Float> num2 = new MyNumber<Float>(1.5f);
		
		System.out.println(num1.toString());
		System.out.println(num2.toString());
		
		
		//Question 4
		MyMath<Number> math = new MyMath<Number>();
		
		System.out.println("\n_Question 4_");
		System.out.println("Tổng 2 số = " + math.Tong(2,5));
		System.out.println("Tổng 3 số = " + math.Tong(2l,5l,7l));
		System.out.println("Tổng 4 số = " + math.Tong(2l, 5, 10.2d, 0.25f));
		
		System.out.println("Hiệu 2 số = " + math.Hieu(2.5f,5l));
		
		math.tinhMu(2.5f, 2);
		math.tinhMu(2l, 1.125d);
	}

}
