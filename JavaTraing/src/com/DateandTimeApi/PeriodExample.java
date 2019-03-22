package com.DateandTimeApi;


import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {

	public static void main(String[] args) {

		// initialDate
		final LocalDate initialDate = LocalDate.now();
		System.out.println("initialDate - " + initialDate);

		// adding period of 5 days to initial date
		final LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		System.out.println("finalDate - " + finalDate);

		// diff of days between two days
		final int diffInDays = Period.between(initialDate, finalDate).getDays();
		System.out.println("diffInDays - " + diffInDays);

		// diff of months between two days
		final int diffInMonths = Period.between(initialDate, finalDate).getMonths();
		System.out.println("diffInMonths - " + diffInMonths);

	}

}

