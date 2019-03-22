package com.DateandTimeApi;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormattingExample {

	public static void main(String[] args) {

		final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		// date time formatting with default format
		final LocalDate localDateWithDefaultFormat = LocalDate.parse("2019-02-25");
		System.out.println("localDateWithDefaultFormat - " + localDateWithDefaultFormat);
		System.out.println("localDateWithDefaultFormat printing with custom format - "
				+ localDateWithDefaultFormat.format(dateFormatter));
		System.out.println("\n\n");

		// date time formatting with custom format (only date) while creating LocalDate itself
		final LocalDate localDateWithCustomFormat = LocalDate.parse("2019/02/25", dateFormatter);
		System.out.println("localDateWithCustomFormat - " + localDateWithCustomFormat);
		System.out.println("localDateWithCustomFormat printing with custom format - "
				+ localDateWithDefaultFormat.format(dateFormatter));
		System.out.println("\n\n");

		final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		// date time formatting with custom format (date & time) while creating LocalDate itself
		final LocalDateTime localDateTimeWithCustomFormat = LocalDateTime.parse("2019/02/25 11:12:12",
				dateTimeFormatter);
		System.out.println("localDateTimeWithCustomFormat - " + localDateTimeWithCustomFormat);
		System.out.println("localDateTimeWithCustomFormat printing with custom format - "
				+ localDateTimeWithCustomFormat.format(dateTimeFormatter));

	}

}


