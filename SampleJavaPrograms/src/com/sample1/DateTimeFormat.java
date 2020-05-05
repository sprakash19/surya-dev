package com.sample1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormat {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		
		SimpleDateFormat sdft = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
		String dateInString = "10-15-2015 10:20:56";
		String dateS = null;
		Date date = null;
		try {
			date = sdft.parse(dateInString);
			System.out.println(date);
			long t= date.getTime();
			long newTime = t+(15*60000);
			Date newDate = new Date(newTime);
			System.out.println(newDate);
			System.out.println(newDate.before(date));
			dateS = sdf.format(date);
			
			System.out.println(dateS);
		
			String times = time.format(date);
			System.out.println(times);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
