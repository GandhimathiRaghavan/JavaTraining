package com.Assignment;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class EvenandDivide {
	
	

	private static Double findSquareOfMaxEvenInLambdaWay(List<Integer> numbers) {
		return numbers.stream()
				.filter(EvenandDivide::isEven) 
				.filter(EvenandDivide::isDivisiblebyfour) 
				
				.max(Comparator.naturalOrder()).map(j->Math.sqrt(j)).get();
	}
	
	
	private static int printMinEvenInLambdaWay(List<Integer> numbers) {
		return numbers.stream()
				.filter(EvenandDivide::isEven) 
				 
				
				.min(Comparator.naturalOrder()).map(j -> j ).get();
	}

	private static boolean isEven(int i) {
		return i % 2 == 0;
	}

	private static boolean isDivisiblebyfour(int i) {
		return i%4 == 0;
	}

	
	
	public static void main(String[] args) {
		final List<Integer> numbers = IntStream.range(1, 20).mapToObj(i -> i).collect(Collectors.toList());
		
		System.out.println("lambda way  max- " + findSquareOfMaxEvenInLambdaWay(numbers));
		
		System.out.println("lambda way min- " + printMinEvenInLambdaWay(numbers));

	}

}



