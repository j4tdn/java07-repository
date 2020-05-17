package declaration_allcation;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		int[] numbers = { 1, 6, 3, 4, 6, 3, 7 };

		// distinct : 1,6,3,4,7
		int[] distinctNumbers = distinct(numbers);
		System.out.print("Distinct Numbers: ");
		Arrays.stream(distinctNumbers).forEach(number -> System.out.print(number + "  "));
		System.out.println();

		// getUniqueNumbers : 1,4,7
		System.out.print("Unique Numbers: ");
		int[] uniqueNumbers = getUniqueNumbers(numbers);
		Arrays.stream(uniqueNumbers).distinct().forEach(number -> System.out.print(number + "  "));
	}

	private static int[] distinct(int[] numbers) {
		int[] result = new int[numbers.length];
		int i = 0;
		for (int number : numbers) {
			if (!contains(result, number, i)) {
				result[i++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}

	private static boolean contains(int[] numbers, int number, int validNumberIndex) {
		for (int i = 0; i <= validNumberIndex; i++) {
			if (numbers[i] == number) {
				return true;
			}
		}
		return false;
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;

		/*
		 * for (int number : numbers) { if (isUnique(numbers, number)) { result[index++]
		 * = number; } }
		 */

		/*
		 * for (int out = 0; out < numbers.length; out++) { int count = 1; for (int in =
		 * 0; in < numbers.length; in++) { if ((in != out) && (numbers[in] ==
		 * numbers[out])) { count++; break; } } if (count == 1) { result[index++] =
		 * numbers[out]; } }
		 */

		boolean[] flags = new boolean[numbers.length];
		Arrays.fill(flags, true);
		for (int out = 0; out < numbers.length; out++) {
			if (flags[out]) {
				for (int in = out + 1; in < numbers.length; in++) {
					if (numbers[out] == numbers[in]) {
						flags[out] = false;
						flags[in] = false;
					}
				}

				if (flags[out]) {
					result[index++] = numbers[out];
				}
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isUnique(int numbers[], int input) {
		int count = 0;
		for (int number : numbers) {
			if (number == input) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}
}
