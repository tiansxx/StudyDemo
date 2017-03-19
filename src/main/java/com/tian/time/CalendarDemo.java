package com.tian.time;

import java.util.Calendar;

/**
 * Java 7 API
 * @author tian
 *
 */

public class CalendarDemo {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println(cal.getTimeZone());
		System.out.println(cal.getTimeInMillis());
		System.out.println(System.currentTimeMillis());
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int dy = cal.get(Calendar.DAY_OF_YEAR);
		int dm = cal.get(Calendar.DAY_OF_MONTH);
		int dw = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(year);
		System.out.println(month);
		System.out.println(dy);
		System.out.println(dm);
		System.out.println(dw);
		
		cal.add(Calendar.YEAR, 1);
		year = cal.get(Calendar.YEAR);
		System.out.println(year);
		
		cal.add(Calendar.MONTH, 10);
		month = cal.get(Calendar.MONTH);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(month);
		
		
	}
}
