package com.DateandTimeApi;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

public class DateCalenderCompatabilityExample {

	public static void main(String[] args) {

		// using existing date object to create LocalDateTime
		final Date date = new Date();
		final LocalDateTime localDateTimeFromDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.out.println("localDateTimeFromDate - " + localDateTimeFromDate);

		// using existing calendar object to create LocalDateTime
		final Calendar calendar = Calendar.getInstance();
		final LocalDateTime localDateTimeFromCalander = LocalDateTime.ofInstant(calendar.toInstant(),
				ZoneId.systemDefault());
		System.out.println("localDateTimeFromCalander - " + localDateTimeFromCalander);

		// using existing instant object to create LocalDateTime
		final Instant instant = Instant.now();
		final LocalDateTime localDateTimeFromEpochSeconds = LocalDateTime.ofEpochSecond(instant.getEpochSecond(), 0,
				ZoneOffset.UTC);
		System.out.println("localDateTimeFromEpochSeconds - " + localDateTimeFromEpochSeconds);

	}

}

