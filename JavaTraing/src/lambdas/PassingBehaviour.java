package lambdas;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PassingBehaviour {
	

	


		public static int sumWithCondition(final List<Integer> numbers, final Predicate<Integer> predicate) {
			return numbers.parallelStream().filter(predicate).mapToInt(i -> i).sum();
		}

		public static void main(String[] args) {
			final List<Integer> numbers = IntStream.range(1, 10).mapToObj(i -> i).collect(Collectors.toList());

			// sum of all numbers
			System.out.println("sum of all the numbers - " + sumWithCondition(numbers, n -> {return true;}));

			// sum of all even numbers
			System.out.println("sum of even numbers - " + sumWithCondition(numbers, i -> i % 2 == 0));

			// sum of all numbers greater than 5
			System.out.println("sum of numbers greater than 5 - " + sumWithCondition(numbers, i -> i > 5));
		}

	}



