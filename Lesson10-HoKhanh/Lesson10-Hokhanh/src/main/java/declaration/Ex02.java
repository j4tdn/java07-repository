package declaration;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[] numbers = { 11, 33, 77, 66, 22 };
		for (int number : printEventNumbers(numbers)) {
			System.out.println(number);
		}
		System.out.println(secondMax(numbers));
		sort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println();
		numbers = insert(numbers, 234, 3);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}

	private static int[] printEventNumbers(int[] numbers) {
		int length = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				length++;
			}
		}

		int[] evenNumbers = new int[length];
		int index = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				evenNumbers[index++] = number;
			}
		}
		return evenNumbers;
	}

	private static void totalOfOddNumbers(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number % 2 != 0) {
				sum += number;
			}
			System.out.println(sum);
		}
	}

	private static int max(int[] numbers) {
		int max = numbers[0];
		for (int number : numbers) {
			if (max < number) {
				max = number;
			}
		}
		return max;
	}

	private static int secondMax(int[] numbers) {
		int max = numbers[0] > numbers[1] ? numbers[0] : numbers[1];
		int secondMax = numbers[0] > numbers[1] ? numbers[1] : numbers[0];
		for (int number : numbers) {
			if (number > max) {
				secondMax = max;
				max = number;
			} else if (number != max && number > secondMax) {
				secondMax = number;
			}
		}
		return secondMax;
	}

	private static void sort(int[] numbers) {
		for (int out = numbers.length - 1; out > 0; out--) {
			for (int in = 0; in < out; in++) {
				if (numbers[in] > numbers[out]) {
					int tmp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = tmp;
				}
			}
		}
	}

	private static int[] insert(int[] numbers, int num, int k) {
		int[] result = new int[numbers.length + 1];
		for (int i = 0; i < k; i++) {
			result[i] = numbers[i];
		}
		result[k] = num;
		for (int i = k + 1; i < result.length; i++) {
			result[i] = numbers[i - 1];
		}
		return result;
	}

	private static int[] insert2(int[] numbers, int num, int k) {
		int[] result = new int[numbers.length + 1];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = numbers[i];
		}

		// shift right 1 unit
		for (int i = result.length - 1; i > k; i--) {
			result[i] = result[i - 1];
		}
		result[k] = num;
		return result;
	}
}
