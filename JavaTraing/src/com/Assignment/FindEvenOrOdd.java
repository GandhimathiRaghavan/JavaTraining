package com.Assignment;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FindEvenOrOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<Integer> intList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

		System.out.println("printing even numbers using Iterator");
		evenIterator(intList);

		System.out.println("printing 0dd numbers using Iterator");
		oddIterator(intList);

		System.out.println("printing even numbers using streams");
		evenStream(intList);

		System.out.println("printing odd numbers using streams");
		oddStream(intList);

	}

	private static void evenIterator(List<Integer> list) {

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int num = it.next();

			if ((num % 2) == 0) {
				System.out.println(num);

			}
		}
	}

	private static void oddIterator(List<Integer> list) {

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int num = it.next();

			if ((num % 2) != 0) {
				System.out.println(num);

			}

		}

	}

	private static void evenStream(List<Integer> list) {

		list.stream().filter(value -> value % 2 == 0).forEach(System.out::println);

	}

	private static void oddStream(List<Integer> list) {

		// ::method reference syntax which is used print value also used to replace
		// lambda which is realy prinnting out values
		// value->System.out.println(value)
		list.stream()
		    .filter(value -> value % 2 != 0)
		    .forEach(System.out::println);
	}

}
