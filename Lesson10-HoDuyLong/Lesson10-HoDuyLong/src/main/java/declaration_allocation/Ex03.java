package declaration_allocation;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		// 1 6 3 4 6 3 7
		// distinct: 1 6 3 4 7
		// getUniqueNumbers: 1 4 7
		int[] numbers = { 1, 6, 3, 0, 4, 6, 3, 7 };
		int[] result1 = distinct(numbers);
		Arrays.stream(result1).forEach(System.out::println);
		System.out.println("=======================");
		int[] result2 = getUniqueNumbers(numbers);
		Arrays.stream(result2).forEach(System.out::println);
		System.out.println("=======================");
		int[] result3 = getUniqueNumbers2(numbers);
		Arrays.stream(result3).forEach(System.out::println);
	}

	private static int[] distinct(int[] numbers) {
		int[] result = new int[numbers.length];
		int i = 0;
		for (int number : numbers) {
			if (!contain(result, number, i)) {
				result[i++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}

	private static boolean contain(int[] result, int number, int validNumberIndex) {
		for (int i = 0; i < validNumberIndex; i++) {
			if (number == result[i]) {
				return true;
			}
		}
		return false;
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
		for (int number : numbers) {
			if (isUnique(numbers, number)) {
				result[index++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isUnique(int[] numbers, int input) {
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (input == numbers[i]) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[] getUniqueNumbers2(int[] numbers) {
		int[] result = new int[numbers.length];
		boolean[] flags = new boolean[numbers.length];
		int index = 0;
		Arrays.fill(flags, true);
		for (int out = 0; out < flags.length; out++) {
			if (flags[out]) {
				for (int in = out + 1; in < flags.length; in++) {
					if (numbers[out] == numbers[in]) {
						flags[in] = false;
						flags[out] = false;
					}
				}
				if (flags[out]) {
					result[index++] = numbers[out];
				}
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}
}
