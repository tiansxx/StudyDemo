package com.tian.time;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

/**
 * Java 8 API
 * 
 * @author tian
 */

public class TimeDemo {

	public static void main(String[] args) {
		clock();
		localDate();
		localTime();
		localDateTime();
		duration();
	}

	/**
	 * clock 可替代System.currentTimeMillis()和TimeZone.getDefault()
	 */
	static void clock() {
		System.out.println(Clock.systemUTC().instant());
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock.instant());
		System.out.println(clock.getZone());
		System.out.println(TimeZone.getDefault().getID());
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
	}
	
	/**
	 * 日期相关
	 */
	static void localDate() {
		LocalDate date = LocalDate.now();
		LocalDate dateFromClock = LocalDate.now(Clock.systemDefaultZone());
		System.out.println(date);
		System.out.println(dateFromClock);
	}
	
	/**
	 * 时间相关
	 */
	static void localTime() {
		LocalTime time = LocalTime.now();
		System.out.println(time);
		LocalTime timeFromClock = LocalTime.now(Clock.systemDefaultZone());
		System.out.println(timeFromClock);
	}
	
	/**
	 * 日期+时间
	 */
	static void localDateTime() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nowFromClock = LocalDateTime.now(Clock.systemDefaultZone());
		System.out.println(now);
		System.out.println(nowFromClock);
		
		//ZonedDateTime可指定时区
		ZonedDateTime z0 = ZonedDateTime.now();
		System.out.println(z0);
		ZonedDateTime z1 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(z1);
		ZonedDateTime z2 = ZonedDateTime.now(Clock.systemUTC());
		System.out.println(z2);
		ZonedDateTime z3 = ZonedDateTime.now(Clock.systemDefaultZone());
		System.out.println(z3);
	}
	
	/**
	 * 时间差
	 */
	static void duration() {
		LocalDateTime from = LocalDateTime.of(2017, Month.FEBRUARY, 1, 0, 0);
		LocalDateTime to = LocalDateTime.of(2017, Month.MARCH, 1, 0, 0);
		Duration duration = Duration.between(from, to);
		System.out.println(duration.toDays());
		System.out.println(duration.toHours());
		
		LocalDateTime result = from.plus(28, ChronoUnit.DAYS);
		System.out.println(result);
	}
}
