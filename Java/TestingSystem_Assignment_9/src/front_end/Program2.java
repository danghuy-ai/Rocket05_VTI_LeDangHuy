package front_end;

import entity.CPU;
import entity.Car;

public class Program2 {

	public static void main(String[] args) {
		
		//Question 1
		CPU cpu = new CPU();
		
		CPU.Processor pro = cpu.new Processor();
		System.out.println(pro.getCache());
		
		CPU.Ram ram = cpu.new Ram();
		System.out.println(ram.getClockSpeed());
		
		
		//Question 2
		Car car1 = new Car("Mazda","8WD","Crysler");
		Car car2 = new Car("Honda","10WD","Crysler-01");
		Car car3 = new Car("Mercedes","12WD","Crysler-2");
		
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
		
		System.out.println(car1.toString());
		System.out.println(car3.toString());
		
		
		//Question 3
		/*
		 * Output của main là:
		 * 
		 * Đây là inner class
		 * Đây là inner class
		 */
		
		
		//Question 4
		/*
		 * Output của main là:
		 * 
		 * Ngày: 31/10/2017
		 * Giờ: 10:15:30
		 */
	}

}
