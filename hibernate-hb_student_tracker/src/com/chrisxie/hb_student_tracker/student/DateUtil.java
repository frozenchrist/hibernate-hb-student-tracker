package com.chrisxie.hb_student_tracker.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	

	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	
	public static String convertDateToString(Date date) {
		
		return formatter.format(date);
		
	}
	
	
public static Date convertStringToDate(String dateString) throws ParseException {
		
		
		return formatter.parse(dateString);
		
	}
	
	
}
