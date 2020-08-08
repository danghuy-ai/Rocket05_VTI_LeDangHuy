package entity;

public class MyMath <T extends Number> {
	
	public T Tong(T ... numbers) {
		Double tong = 0d;
		
		for (T number : numbers) {
			tong += number.doubleValue();
		}
		
		return (T) tong;
	}
	
	public T Hieu(T num1, T num2) {
		Double hieu = num1.doubleValue() - num2.doubleValue();
		
		return (T) hieu;
	}
	
	public <T> void tinhMu(T x, T y) {
		
		//Tính giá trị x^y
		double z = Math.pow(((Number) x).doubleValue(), ((Number) y).doubleValue());
		System.out.println("Giá trị của " + x + "^" + y + " = " + z);
		
	}

}
