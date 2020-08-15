package com.vti.lession11.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static int inputInt(String errorMessage) {
		while (true) { 
			try {
				int number = Integer.parseInt(scanner.nextLine().trim());
				
				if(number >= 0) {
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
				float number = Float.parseFloat(scanner.nextLine().trim());
				
				if(number >= 0) {
					return number;
				}
				else
					System.err.println(errorMessage);
				
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
	
	public static LocalDate inputLocalDate() {
		while (true) { 
			String date = "";
	        LocalDate localDate = null;
	        DateTimeFormatter formatter = null;
	        try {
				date = ScannerUtils.inputString("Chưa nhập ngày. Vui lòng nhập lại!");
		        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        localDate = LocalDate.parse(date, formatter);
		        return localDate;
	        } catch (DateTimeParseException e) {
	        	System.err.println("Vui lòng nhập ngày theo format dd-MM-yyyy!");
	        }
		}
	}
	
	public static LocalDateTime inputLocalDateTime() {
		while (true) { 
			String date = "";
			LocalDateTime localDate = null;
	        DateTimeFormatter formatter = null;
	        try {
				date = ScannerUtils.inputString("Chưa nhập ngày. Vui lòng nhập lại!");
		        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		        localDate = LocalDateTime.parse(date, formatter);
		        return localDate;
	        } catch (DateTimeParseException e) {
	        	System.err.println("Vui lòng nhập ngày theo định dạng dd-MM-yyyy HH:mm:ss!");
	        }
		}
	}
	
	public static String convertLocalDateTimeToString(LocalDateTime date) {
        
        String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return formattedDate;
	}
}
