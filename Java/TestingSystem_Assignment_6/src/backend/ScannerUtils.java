package backend;

import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static int inputInt(String errorMessage) {
		while (true) { 
			try {
				int number = Integer.parseInt(scanner.nextLine().trim());
				
				if(number > 0) {
					return number;
				}
				else
					System.err.println(errorMessage);
				
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString(String errorMessage) {
		while (true) {
			String str = scanner.nextLine().trim();
			if (!str.isEmpty()) {
				return str;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
	
}
