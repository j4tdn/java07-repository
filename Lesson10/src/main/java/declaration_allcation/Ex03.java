package declaration_allcation;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		// 1, 6 , 3, 4, 6 , 3, 7
		// distinct: 1, 6, 3, 4, 7
		// getUniqueNumbers
		int[] numbers = { 1, 6, 3, 0, 4, 6, 3, 7, 6, 6 , 6};
//		Arrays.stream(numbers).distinct().forEach(number -> System.out.println(number));
		numbers = getUniqueNumbers2(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.println(number));
	}

	private static void distinct(int[] numbers) {

		for (int i = 0; i < numbers.length - 2; i++) {
			for (int j = i + 1; j < numbers.length - 1; j++) {
				if (numbers[i] == numbers[j]) {
					numbers[j] = 0;
				}
			}
		}

		for (int number : numbers) {
			if (number != 0) {
				System.out.println(number);
			}
		}
	}

	private static int[] getUniqueNumbers2(int[] numbers) {
		boolean[] flags = new boolean[numbers.length];
		int[] results = new int[numbers.length];
		int index = 0;
		Arrays.fill(flags, true);
		for (int out = 0; out < numbers.length; out++) {
			for (int in = out + 1; in < numbers.length; in++) {
				if (flags[out] && numbers[out] == numbers[in]) {
					flags[out] = flags[in] = false;
				}
			}
			if (flags[out]) {
				results[index++] = numbers[out];
			}
		}
		return Arrays.copyOfRange(results, 0, index);
	}
	
	private static int[] distinct2(int[] numbers) {
		int[] results = new int[numbers.length];
		results[0] = numbers[0];
		int i = 1;
		for (int number : numbers) {
			if (!contains(results, number, i)) {
				results[i++] = number;
			}
		}
		return Arrays.copyOfRange(results, 0, i);
	}

	private static boolean contains(int[] results, int number, int index) {
		for (int i = 0; i < index; i++) {
			if (number == results[i]) {
				return true;
			}
		}
		return false;
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] results = new int[numbers.length];
		int index = 0;

		for (int number : numbers) {
			if (isUnique(numbers, number)) {
				results[index++] = number;
			}
		}
		
		return Arrays.copyOfRange(results, 0, index);
	}

	private static boolean isUnique(int[] numbers, int input) {
		int count = 0;

		for (int item : numbers) {
			if (input == item) {
				count++;
			}
			if (count == 2) {
				return false;
			}
		}

		return true;
	}

	private static void printArray(int[] array) {
		for (int item : array) {
			System.out.println(item);
		}
	}
}
