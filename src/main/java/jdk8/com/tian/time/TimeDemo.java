package jdk8.com.tian.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDemo {

	public static void main(String[] args) {
		
		Clock clock = Clock.systemUTC();
		System.out.println(clock.getZone());
		System.out.println(clock.instant());
		System.out.println(clock.millis());
		
		Clock systemDefaultZone = Clock.systemDefaultZone();
		System.out.println(systemDefaultZone.getZone());
		System.out.println(systemDefaultZone.instant());
		System.out.println(systemDefaultZone.millis());
		
		//当前日期
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.now(clock));
		
		//当前时间
		System.out.println(LocalTime.now());
		System.out.println(LocalDate.now(clock));
		
		//日期+时间
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now(clock));
		
		//
		System.out.println(ZonedDateTime.now());
		System.out.println(ZonedDateTime.now(clock));
		System.out.println(ZonedDateTime.now(systemDefaultZone));
		
		//instant	时间戳
		Instant instant = Instant.now();
		System.out.println(instant);
		
		//duration
		
		
		//时间计算
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime plusMinutes = now.plusMinutes(10);
		System.out.println(now + "\t" + plusMinutes);
		
		//format
		System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(LocalDate.parse("20191111", DateTimeFormatter.BASIC_ISO_DATE));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(now.format(formatter));
	}
}
