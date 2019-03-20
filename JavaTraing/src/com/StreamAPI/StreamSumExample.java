package com.StreamAPI;


	

	import java.util.Arrays;
	import java.util.Iterator;
	import java.util.List;

	public class StreamSumExample {

		public static void main(String[] args) {
			final List<Integer> intList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 11, 12, 13, 14, 15 });
			System.out.println("sumIterator -> " + sumIterator(intList));
			System.out.println("sumStream -> " + sumStream(intList));
		}

		private static int sumIterator(List<Integer> list) {
			Iterator<Integer> it = list.iterator();
			int sum = 0;
			while (it.hasNext()) {
				int num = it.next();
				if (num > 10) {
					sum += num;
				}
			}
			return sum;
		}

		private static int sumStream(List<Integer> list) {
			return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
		}

	}


