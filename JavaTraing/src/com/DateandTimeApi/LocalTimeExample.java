package com.DateandTimeApi;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {

	public static void main(String[] args) {

		// local time from system lock
		final LocalTime localTimeFromSystemClock = LocalTime.now();
		System.out.println("local time from system lock - " + localTimeFromSystemClock);

		// local time by passing hours, minutes, seconds
		final LocalTime localTimeByPassingHoursMinutesSecs = LocalTime.of(14, 30, 25);
		System.out.println("local time by passing hours, minutes, seconds - " + localTimeByPassingHoursMinutesSecs);

		// local time by parsing string
		final LocalTime localTimeByParsingSTring = LocalTime.parse("15:30:55");
		System.out.println("local time by parsing string - " + localTimeByParsingSTring);

		// getting time after one hour
		final LocalTime timeAfterOneHour = LocalTime.now().plusHours(1);
		System.out.println("timeAfterOneHour - " + timeAfterOneHour);

		// getting time before one hour
		final LocalTime timeBeforeOneHour = LocalTime.now().minus(1, ChronoUnit.HOURS);
		System.out.println("timeBeforeOneHour - " + timeBeforeOneHour);

		// comparing times
		final boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
		System.out.println("06:30 < 07:30 - " + isbefore);

		// setting max time
		final LocalTime maxTime = LocalTime.MAX;
		System.out.println("Max Time - " + maxTime);

		// setting min time
		final LocalTime minTime = LocalTime.MIN;
		System.out.println("Min Time - " + minTime);

	}

}

