package com.DateandTimeApi;


import java.time.Duration;
import java.time.LocalTime;

public class DurationExample {

	public static void main(String[] args) {

		// initialTime
		final LocalTime initialTime = LocalTime.now();
		System.out.println("initialTime - " + initialTime);

		// adding duration of 5 hours to initial Time
		final LocalTime finalTime = initialTime.plus(Duration.ofHours(5));
		System.out.println("finalTime - " + finalTime);

		// diff of seconds between two times
		final long diffInSeconds = Duration.between(initialTime, finalTime).getSeconds();
		System.out.println("diffInSeconds - " + diffInSeconds);

	}

}

