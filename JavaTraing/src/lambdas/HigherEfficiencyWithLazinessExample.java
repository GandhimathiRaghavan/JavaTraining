package lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// write a program to find out the maximum odd number in the range 3 to 11 and return square of it
public class HigherEfficiencyWithLazinessExample {

	// traditional way
	private static int findSquareOfMaxOdd(List<Integer> numbers) {
		int max = 0;
		for (int i : numbers) {
			if (i % 2 != 0 && i > 3 && i < 11 && i > max) {
				max = i;
			}
		}
		return max * max;
	}

	// lambda way
	private static int findSquareOfMaxOddInLambdaWay(List<Integer> numbers) {
		return numbers.stream()
				.filter(HigherEfficiencyWithLazinessExample::isOdd) // Predicate is functional interface and
				.filter(HigherEfficiencyWithLazinessExample::isGreaterThan3) // we are using lambdas to initialize it
				.filter(HigherEfficiencyWithLazinessExample::isLessThan11) // rather than anonymous inner classes
				.max(Comparator.naturalOrder()).map(j -> j * j).get();
	}

	private static boolean isOdd(int i) {
		return i % 2 != 0;
	}

	private static boolean isGreaterThan3(int i) {
		return i > 3;
	}

	private static boolean isLessThan11(int i) {
		return i < 11;
	}
	
	public static void main(String[] args) {
		final List<Integer> numbers = IntStream.range(1, 10).mapToObj(i -> i).collect(Collectors.toList());
		
		System.out.println("traditional way - " + findSquareOfMaxOdd(numbers));
		System.out.println("lambda way - " + findSquareOfMaxOddInLambdaWay(numbers));
	}

}
