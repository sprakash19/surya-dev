package com.notableapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static Date getUtilDate(String date, boolean withTime) {
		try {
			return getDateFormat(withTime).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String extractOnlyDate(String date) {
		try {
			return getDateFormat(false).format(getDateFormat(false).parse(date)) ;
		} catch (ParseException e) {
			return null;
		}
		
	}
	
	
	private static SimpleDateFormat getDateFormat(boolean withTime) {
		return withTime ? new SimpleDateFormat("MM-dd-yyyy hh:mm:ss") : new SimpleDateFormat("MM-dd-yyyy");
	}
	
	
	
	public static long getTime(String date) {
		
		return getUtilDate(date, true).getTime();
		
	}
	
	

}
