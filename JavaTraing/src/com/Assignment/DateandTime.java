package com.Assignment;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateandTime {
   public static void main(String args[]) {
	
	
	   //Print your Birth Date and Time
			
			LocalDate date = LocalDate.parse("1947-07-14");
			
			System.out.println("printing  birthdate in specific format:    "+date.format(DateTimeFormatter.ofPattern("[yyyy-MMM-dd] [hh:mm:ss]")));
			
			
			
			
			// creating current datetime with specific time zone
						final ZoneId pacificTimeZone = ZoneId.of("Pacific/Apia");
						final ZonedDateTime currentDateTimeWithSPecificTimeZone = ZonedDateTime.now(pacificTimeZone);
						System.out.println("current datetime with Pacific zone - " + currentDateTimeWithSPecificTimeZone);
						
						final ZoneId ISTTimeZone = ZoneId.of("Asia/Kolkata");
						final ZonedDateTime currentDateTimeWithSPecificTimeZone1 = ZonedDateTime.now(ISTTimeZone);
						System.out.println("current datetime with IST time zone - " + currentDateTimeWithSPecificTimeZone1);
						
						final ZoneId ESTTimeZone = ZoneId.of("-05:00");
						final ZonedDateTime currentDateTimeWithSPecificTimeZone2 = ZonedDateTime.now(ESTTimeZone);
						System.out.println("current datetime with EST time zone - " + currentDateTimeWithSPecificTimeZone2);
			
			
			
			// Printing  Difference between two dates  now().minusDays(3)
			
			final LocalDate initialDate = LocalDate.parse("2019-03-19");
			System.out.println("initialDate - " + initialDate);

			// adding period of 20 days to initial date
			final LocalDate finalDate = initialDate.plus(Period.ofDays(20));
			System.out.println("finalDate - " + finalDate);

			// diff of days between two dates
			final int diffInDays = Period.between(initialDate, finalDate).getDays();
			System.out.println("diffInDays - " + diffInDays);

			// diff of months between two dates
			final int diffInMonths = Period.between(initialDate, finalDate).getMonths();
			System.out.println("diffInMonths - " + diffInMonths);
			
}
   
}
