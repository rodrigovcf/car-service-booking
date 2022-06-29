package com.carservice.useful;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparation {
	
	private DateComparation() {}

	public static boolean comparation(String dateText) {
		try {
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			Date dateInput = sdformat.parse(dateText);
			
			if (dateInput.after(today) || dateInput.equals(today)) 
				return true;
			
		} catch (ParseException ex) {
			System.err.print(ex.toString());
		}
		return false;
	}
}
