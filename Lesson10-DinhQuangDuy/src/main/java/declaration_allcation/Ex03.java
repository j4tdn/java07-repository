package declaration_allcation;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 6, 0, 4, 3, 6, 7 };

		int[] results = distinct(numbers);
		Arrays.stream(results).forEach(number -> System.out.print(number + " "));
		// Arrays.stream(numbers).distinct().forEach(number -> System.out.print(number +
		// " "));

		System.out.println("\n----------");

		results = getUniqueNumbersV3(numbers);
		Arrays.stream(results).forEach(number -> System.out.print(number + " "));

	}

	private static int[] distinct(int[] numbers) {
		int[] results = new int[numbers.length];
		int index = 0;
		
		for (int number : numbers) {
			if (!contains(results, number, index)) {
				results[index++] = number;
			}
		}
		return Arrays.copyOfRange(results, 0, index);
	}
	//1, 3, 6, 0, 4, 3, 6, 7
	private static boolean contains(int[] results, int number, int validNumberIndex) {
		for (int i = 0; i < validNumberIndex; i++) {
			if (results[i] == number) {
				return true;
			}
		}
		return false;
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] results = new int[numbers.length];
		
		int count = 0;

		for (int i = 0; i < numbers.length; i++) {
			boolean isUnique = false;
			for (int j = 0; j < numbers.length; j++) {
				if (i != j && numbers[i] == numbers[j]) {
					isUnique = true;
					break;
				} 
			}
			if (!isUnique) {
				results[count] = numbers[i];
				count++;
			}
		}

		return Arrays.copyOfRange(results, 0, count);
	}

	private static int[] getUniqueNumbersV2(int[] numbers) {
		int[] results = new int[numbers.length];
		int count = 0;

		for (int number : numbers) {
			if (isUnique(numbers, number)) {
				results[count++] = number;
			}
		}

		return Arrays.copyOf(results, count);
	}
	
	private static int[] getUniqueNumbersV3(int[] numbers) {
		
		int[] results = new int[numbers.length];
		boolean[] flags = new boolean[numbers.length];
		Arrays.fill(flags, true);
		int index = 0;

		for (int out = 0; out < numbers.length; out++) {
			if (flags[out]) {
				for (int in = out + 1; in < numbers.length; in++) {
					if (numbers[out] == numbers[in]) {
						flags[out] = flags[in] = false;
					}
				}

				if (flags[out]) {
					results[index++] = numbers[out];
				}
			}
		}

		return Arrays.copyOf(results, index);
	}

	private static boolean isUnique(int[] numbers, int input) {
		int count = 0;
		for (int number : numbers) {
			if (input == number) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return true;
	}

}
