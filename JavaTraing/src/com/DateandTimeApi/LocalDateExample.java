package com.DateandTimeApi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {

	public static void main(String[] args) {

		// instance of current date from the system clock
		final LocalDate localDateFromSystemClock = LocalDate.now();
		System.out.println("instance of current date from the system clock - " + localDateFromSystemClock);

		// LocalDate representing a specific day, month and year
		final LocalDate localDateWithYearMonthDateAsParams = LocalDate.of(2019, 02, 25);
		System.out.println(
				"LocalDate representing a specific day, month and year - " + localDateWithYearMonthDateAsParams);

		// LocalDate representing a specific day, month and year by parsing string
		final LocalDate localDateParsedFromString = LocalDate.parse("2019-02-25");
		System.out.println("LocalDate representing a specific day, month and year by parsing string - "
				+ localDateParsedFromString);

		// add days
		final LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println("tomorrow - " + tomorrow);

		// add months
		final LocalDate nextMonthSameDay = LocalDate.now().plusMonths(1);
		System.out.println("nextMonthSameDay - " + nextMonthSameDay);

		// add years
		final LocalDate nextYearSameMonthDay = LocalDate.now().plusYears(1);
		System.out.println("nextYearSameMonthDay - " + nextYearSameMonthDay);

		// subtract days
		final LocalDate yesterday = LocalDate.now().minus(1, ChronoUnit.DAYS);
		System.out.println("yesterday - " + yesterday);

		// subtract months
		final LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println("previousMonthSameDay - " + previousMonthSameDay);

		// subtract years
		final LocalDate previousYearSameMonthDay = LocalDate.now().minus(1, ChronoUnit.YEARS);
		System.out.println("previousYearSameMonthDay - " + previousYearSameMonthDay);

		// comparing dates - isBefore
		final boolean before = LocalDate.parse("2019-02-26").isBefore(LocalDate.parse("2019-02-25"));
		System.out.println("2019-02-26 < 2019-02-25 - " + before);

		// comparing dates - isAfter
		final boolean after = LocalDate.parse("2019-02-26").isAfter(LocalDate.parse("2019-02-25"));
		System.out.println("2019-02-26 > 2019-02-25 - " + after);

		// leap year check
		final boolean isLeapYear = LocalDate.now().isLeapYear();
		System.out.println("isLeapYar - " + isLeapYear);

		// getting day of week
		final DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		System.out.println("day of week - " + dayOfWeek);

		// adjusting date time
		final LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("firstDayOfMonth - " + firstDayOfMonth);

	}

}

