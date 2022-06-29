package com.carservice.useful;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class DateComparation {

	private DateComparation() {}

	private static Logger log = Logger.getLogger(DateComparation.class.getName());	

	@SuppressWarnings("deprecation")
	public static boolean comparation(String dateText) {
		try {
			boolean isToday = false;
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			Date dateInput = sdformat.parse(dateText);

			if((today.getDay() == dateInput.getDay()) &&
				(today.getMonth() == dateInput.getMonth()) &&
					(today.getYear() == dateInput.getYear()))
						isToday = true;
			
			if (dateInput.after(today) || isToday) 
				return true;

		} catch (ParseException ex) {
			log.info("Error " + ex.toString());
		}
		return false;
	}
}
