package com.DateandTimeApi;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeExample {

	public static void main(String[] args) {

		// creates the local datetime with system clock and default time zone
		final ZonedDateTime currentDateTime = ZonedDateTime.now();
		System.out.println("local datetime with system clock and default time zone - " + currentDateTime);

		// all available time zones
		final Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println("all available time zones are - " + allZoneIds);

		// creating current datetime with specific time zone
		final ZoneId europeParisTimeZone = ZoneId.of("Europe/Paris");
		final ZonedDateTime currentDateTimeWithSPecificTimeZone = ZonedDateTime.now(europeParisTimeZone);
		System.out.println("current datetime with specific time zone - " + currentDateTimeWithSPecificTimeZone);

		// creating specific datetime with specific time zone
		final LocalDateTime localDateTime = LocalDateTime.of(2019, 02, 25, 3, 32);
		final ZonedDateTime specificDateTimeWithSPecificTimeZone = ZonedDateTime.of(localDateTime, europeParisTimeZone);
		System.out.println("specific datetime with specific time zone - " + specificDateTimeWithSPecificTimeZone);

		final ZonedDateTime zonedDateTimeParsingString = ZonedDateTime.parse("2019-02-25T10:15:30+01:00[Europe/Paris]");
		System.out.println("zonedDateTimeParsingString - " + zonedDateTimeParsingString);

		// next day
		final ZonedDateTime nextDay = ZonedDateTime.now().plusDays(1);
		System.out.println("next day - " + nextDay);

		// yesterday day
		final ZonedDateTime yesterday = ZonedDateTime.now().minusDays(1);
		System.out.println("yesterday day - " + yesterday);

		// comparing datetimes
		final boolean isBefore = nextDay.isBefore(yesterday);
		System.out.println("comparing datetimes next day < yesterday day - " + isBefore);

	}

}

