package Ass_3;

import java.util.Scanner;

public class Exercise_4 {

	public static void main(String[] args) {
		//Question 1
		Question1();
		
		//Question 2
		Question2();
		
		//Question 3
		Question3();
		
		//Question 4
		Question4();
		
		//Question 5
		Question5();
		
		//Question 6
		Question6();
		
		//Question 7
		Question7();
		
		//Question 8
		Question8();
		
		//Question 9
		Question9();
		
		//Question 10
		Question10();
		
		//Question 11
		Question11();
		
		//Question 12
		Question12();
		
		//Question 13
		Question13();
		
		//Question 14
		Question14();
		
		//Question 15
		Question15();
		
		//Question 16
		Question16();
	}
	static void Question1() {
		System.out.println("---Question 1---");
		Scanner scanner = new Scanner(System.in);
		String nhap;
		System.out.println("Nhập 1 xâu ký tự: ");
		nhap = scanner.nextLine();

		String[] tu = nhap.split(" ");   // spli ttách chuỗi theo biểu thức chính quy trả về mảng chuỗi
		System.out.println("Số lượng các từ trong xâu trên: " + tu.length);

		//scanner.close();
	}
	
	static void Question2() {
		System.out.println("\n---Question 2---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhập 1 xâu ký tự s1: ");
		String nhap1 = scanner.nextLine();
		
		System.out.println("Nhập 1 xâu ký tự s2: ");
		String nhap2 = scanner.nextLine();
		
		System.out.println("Xâu ký tự sau khi nối s2 vào sau s1: " + nhap1.concat(nhap2));

		//scanner.close();
	}
	
	static void Question3() {
		System.out.println("\n---Question 3---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Chỉ nhập tên của bạn: ");
		String name = scanner.nextLine();

		String kyTuDau = name.substring(0, 1).toUpperCase();

		String conLai = name.substring(1);

		name = kyTuDau + conLai;

		System.out.println("Tên sau khi chuẩn hóa: "+name);
	}
	
	static void Question4() {
		System.out.println("\n---Question 4---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Chỉ nhập tên của bạn: ");
		String name = scanner.nextLine();
		name = name.toUpperCase();
		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ký tự thứ " + i + " là: " + name.charAt(i));
		}
	}
	
	static void Question5() {
		System.out.println("\n---Question 5---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhập họ của bạn: ");
		String nhapHo = scanner.nextLine();
		
		System.out.println("Nhập tên của bạn: ");
		String nhapTen = scanner.nextLine();
		
		String space = " ";
		String spaceTen = space.concat(nhapTen);
		
		System.out.println("Tên đầy đủ của bạn là: " + nhapHo.concat(spaceTen));
	}
	
	static void Question6() {
		System.out.println("\n---Question 6---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhập họ và tên đầy đủ của bạn: ");
		String name = scanner.nextLine();
		
		String[] arrNames = name.split(" ");
		String ho  = null;
		String dem  = null;
		String ten  = null;
		int lengthName = arrNames.length;
		String space = " ";
		String spaceTen;
		
		if(lengthName >= 4) {
			ho = arrNames[0];
			dem = arrNames[1];
			ten = arrNames[lengthName -1];
			for(int i=2; i < (lengthName - 1); i++) {
				spaceTen = space.concat(arrNames[i]);
				dem = dem.concat(spaceTen);
			}
		}
		else if(lengthName == 3) {
			ho = arrNames[0];
			dem = arrNames[1];
			ten = arrNames[2];
		}
		else if(lengthName == 2) {
			ho = arrNames[0];
			ten = arrNames[1];
			dem = "Người dùng không có tên đệm!";
		}
		else {
			System.out.println("Vui lòng nhập đầy đủ họ và tên!!");
			return;
		}
		
		System.out.println("Họ là: " + ho);
		System.out.println("Tên đệm là: " + dem);
		System.out.println("Tên là: " + ten);
	}
	
	static void Question7() {
		System.out.println("\n---Question 7---");
		Scanner scanner = new Scanner(System.in);
		String name;

		System.out.println("Nhập họ tên đầy đủ của bạn là: ");
		name = scanner.nextLine();

		scanner.close();

		name = name.trim(); //Loai bo khoang trang o dau va cuou chuoi
		name = name.replaceAll("\\s+", " "); //Thay thế nhiều khoảng trắng giữa các chuỗi thành 1 khoảng trắng duy nhát

		String[] words = name.split(" ");
		name = "";

		for (String word : words) {
			String kyTuDau = word.substring(0, 1).toUpperCase();
			String conLai = word.substring(1);
			word = kyTuDau + conLai;

			name += word + " ";
		}

		System.out.println("Họ tên sau khi chuẩn hóa: " + name);
	}
	
	static void Question8() {
		System.out.println("\n---Question 8---");
		String[] groups = { "Lập trình Java", "Lê Đăng Huy", "Java cho newbie", "Java cho Java" };

		for (String group : groups) {
			if (group.contains("Java")) {
				System.out.println(group);
			}
		}
	}
	static void Question9() {
		System.out.println("\n---Question 9---");
		String[] groups = { "Lập trình Java", "Lê Đăng Huy", "Java", "Dev C++" };

		for (String group : groups) {
			if (group.equals("Java")) {
				System.out.println(group);
			}
		}
	}
	
	static void Question10() {
		System.out.println("\n---Question 10---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhập chuỗi 1: ");
		String nhap1 = scanner.nextLine();
		
		System.out.println("Nhập chuỗi 2: ");
		String nhap2 = scanner.nextLine();
		
		String kiemTra = "";
		
		for (int i = (nhap2.length() - 1); i>=0; i--) {
			kiemTra += nhap2.substring(i, i + 1);
		}
		if (nhap1.equals(kiemTra)) {
			System.out.println("Đây là chuỗi đảo ngược!");
		}
	}
	
	static void Question11() {
		System.out.println("\n---Question 11---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhập chuỗi kiểm tra ký tự 'a': ");
		String nhap = scanner.nextLine();
		
		int soLuong = 0;
		for (int i = 0; i < nhap.length(); i++) {
			if (nhap.charAt(i) == 'a') {
				soLuong++;
			}
		}
		System.out.println("Số lượng ký tự 'a' có trong chuỗi là: "+soLuong);
	}
	
	static void Question12() {
		System.out.println("\n---Question 12---");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhập chuỗi: ");
		String nhap = scanner.nextLine();
		
		String kiemTra = "";
		
		for (int i = (nhap.length() - 1); i>=0; i--) {
			kiemTra += nhap.substring(i, i + 1);
		}
		System.out.println("Chuỗi sau khi đảo ngược: " + kiemTra);
	}
	
	static void Question13() {
		System.out.println("\n---Question 13---");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập chuỗi kiểm tra: ");
		String nhap = scanner.nextLine();

		for (int i=0; i<nhap.length(); i++) {
			if (kiemTraSo(nhap.charAt(i))) {
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
	}
	
	public static boolean kiemTraSo(char num) {
		if (num >= '0' && num <= '9') {
			return true;
		}
		return false;
	}
	
	static void Question14() {
		System.out.println("\n---Question 14---");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập 1 chuỗi: ");
		String nhap = scanner.nextLine();

		nhap = nhap.replaceAll("e", "*");
		
		System.out.println("Chuỗi sau khi bị thay thế: " + nhap);
	}
	
	static void Question15() {
		System.out.println("\n---Question 15---");
		Scanner scanner = new Scanner(System.in);
		String str;

		System.out.println("Nhập chuỗi muốn đảo ngược: ");
		str = scanner.nextLine();

		scanner.close();

		str = str.trim(); //Loai bo khoang trang o dau va cuou chuoi
		str = str.replaceAll("\\s+", " "); //Thay thế nhiều khoảng trắng giữa các chuỗi thành 1 khoảng trắng duy nhát

		String[] words = str.split(" ");
		String kiemTra = "";
		
		for (int i = words.length - 1; i >= 0; i--) {
			kiemTra += words[i] + " ";
		}
		System.out.println("Chuỗi sau khi đảo ngược: " + kiemTra);
	}
	
	@SuppressWarnings("resource")
	static void Question16() {
		System.out.println("\n---Question 16---");
		Scanner scanner = new Scanner(System.in);
		
		String str;
		System.out.println("Nhập chuỗi: ");
		str = scanner.nextLine();

		int n;
		System.out.println("Nhập n (n>=0): ");
		n = scanner.nextInt();

		if (str == null || str=="" || str.length() % n != 0) {
			System.out.println("KO");
			return;
		}

		for (int i=0; i<str.length(); i+=n) {
			System.out.println(str.substring(i, i+n));
		}
		scanner.close();
	}
}
