package com.carservice.useful;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class DateComparation {

	private DateComparation() {}

	private static Logger log = Logger.getLogger(DateComparation.class.getName());	

	public static boolean comparation(String dateText) {
		try {
			boolean isToday = false;
			SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
			Date today = new Date();
			Date dateInput = sdformat.parse(dateText);

			Calendar calToday = Calendar.getInstance();
			calToday.setTime(today);

			Calendar calInput = Calendar.getInstance();
			calInput.setTime(dateInput);

			if((calToday.get(Calendar.DAY_OF_MONTH) == calInput.get(Calendar.DAY_OF_MONTH)) &&
					(calToday.get(Calendar.MONTH) == calInput.get(Calendar.MONTH)) &&
					(calToday.get(Calendar.YEAR)  == calInput.get(Calendar.YEAR)))
				isToday = true;

			if (calInput.after(calToday) || isToday) 
				return true;

		} catch (ParseException ex) {
			log.info("Error " + ex.toString());
		}
		return false;
	}
}
