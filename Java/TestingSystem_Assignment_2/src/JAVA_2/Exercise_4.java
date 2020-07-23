package JAVA_2;

import java.time.LocalDate;
import java.util.Random;

public class Exercise_4 {

	public static void main(String[] args) {
		Random random = new Random();
		//Question 1
		int x = random.nextInt();
		System.out.println(x);
		
		
		//Question 2
		float b = random.nextInt();
		System.out.println(b);
		
		
		//Question 3
		String[] ten = { "Huy", "Nam", "Mai", "Duc", "Luc" };
		int sl = random.nextInt(ten.length);
		System.out.println("1 bạn bất kỳ có tên: " + ten[sl]);
		
		
		//Question 4
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		long randomInt = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngày ngẫu nhiên từ 24-07-1995 tới 20-12-1995: "+randomDay);
		
		
		//Question 5
		int now = (int) LocalDate.now().toEpochDay();
		randomInt = now - random.nextInt(365);
		randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngày ngẫu nhiên trong khoảng 1 năm trước: "+randomDay);
		
		
		//Question 6
		int now1 = (int) LocalDate.now().toEpochDay();
		randomInt = now1 - random.nextInt(737300);
		randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println("Ngày ngẫu nhiên trong quá khứ: "+randomDay);
		
		
		//Question 7
		int c = random.nextInt(999 - 100 + 1) + 100;
		System.out.println("Số ngẫu nhiên có 3 chữ số: "+c);
	}

}
