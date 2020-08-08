package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Utils {
	
	public static LocalDate convertStringToLocalDate(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(dateStr, formatter);
		return localDate;
	}
	
	public static String convertLocalDateToString(LocalDate date) {
        
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return formattedDate;
	}
}
