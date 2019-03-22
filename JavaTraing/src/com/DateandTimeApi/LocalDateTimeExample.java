package com.DateandTimeApi;


import java.time.LocalDateTime;

public class LocalDateTimeExample {

	public static void main(String[] args) {

		// instance of current datetime from the system clock
		final LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("instance of current datetime from the system clock - " + currentDateTime);

		// LocalDateTime representing a specific day, month and year, hours, minutes
		final LocalDateTime specificDateTime = LocalDateTime.of(2019, 02, 25, 06, 30);
		System.out.println(
				"LocalDateTime representing a specific day, month and year, hours, minutes - " + specificDateTime);

		// LocalDateTime by parsing string
		final LocalDateTime specificDateTimeByParsingString = LocalDateTime.parse("2015-02-20T06:30:00");
		System.out.println("LocalDateTime by parsing string - " + specificDateTimeByParsingString);

		// next day with same time
		final LocalDateTime nextDayWithSameTime = LocalDateTime.now().plusDays(1);
		System.out.println("next day with same time - " + nextDayWithSameTime);

		// yesterday day with same time
		final LocalDateTime yesterdayDayWithSameTime = LocalDateTime.now().minusDays(1);
		System.out.println("yesterday day with same time - " + yesterdayDayWithSameTime);

		// comparing datetimes
		final boolean isBefore = nextDayWithSameTime.isBefore(yesterdayDayWithSameTime);
		System.out.println("comparing datetimes next day < yesterday day - " + isBefore);

	}

}

