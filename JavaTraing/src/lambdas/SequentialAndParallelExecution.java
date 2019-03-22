package lambdas;

import java.util.stream.IntStream;


public class SequentialAndParallelExecution {
	
	
	


		// Traditional approach
		private static boolean isPrimeOldWay(final int number) {
			if (number < 2)
				return false;
			for (int i = 2; i < number; i++) {
				if (number % i == 0)
					return false;
			}
			return true;
		}

		// Lambda sequential approach
		private static boolean isPrimeLambdaSequentialWay(final int number) {
			return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
		}

		// Lambda parallel approach
		private static boolean isPrimeLambdaParallelWay(final int number) {
			return number > 1 && IntStream.range(2, number).parallel().noneMatch(index -> number % index == 0);
		}

		// Lambda sequential approach
		private static void printNumbersInSequenceUntil(final int number) {
			IntStream.range(1, number).forEach(num -> System.out.println("stream, number is - " + num));
		}

		// Lambda parallel approach
		private static void printNumbersInParallelUntil(final int number) {
			IntStream.range(1, number).parallel().forEach(num -> System.out.println("parallel stream, number is - " + num));
		}

		public static void main(String[] args) {
			System.out.println("Traditional approach, is 113 primer number ? " + isPrimeOldWay(113));
			System.out.println("Lambda sequentail approach, is 113 primer number ? " + isPrimeLambdaSequentialWay(113));
			System.out.println("Lambda parallel approach, is 113 primer number ? " + isPrimeLambdaParallelWay(113));

			System.out.println("printing number until 10 in sequence");
			printNumbersInSequenceUntil(10);

			System.out.println("printing number until 10 in parallel");
			printNumbersInParallelUntil(10);
		}

	}



