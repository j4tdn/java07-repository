package declaration_allcation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[] numbers = { 11, 33, 77, 66, 22 };
		int[] evenNumbers = printEvenNumbers(numbers);
		Arrays.stream(evenNumbers).forEach(number -> System.out.print(number + "  "));
		System.out.println();
		System.out.println("Total Of Odd Numbers: " + totalOfOddNumbers(numbers));
		numbers[0] = 199;
		System.out.println("Max: " + max(numbers));
		System.out.println("Second Max: " + secondMax(numbers));
		sort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + "  "));
		System.out.println();
		// Arrays.stream(numbers).forEach(System.out::print);
		numbers = insertV2(numbers, 2, 1);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + "  "));
	}

	private static int[] printEvenNumbers(int[] numbers) {
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

	private static int totalOfOddNumbers(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number % 2 != 0) {
				sum += number;
			}
		}
		return sum;
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
		int max = (numbers[0] > numbers[1]) ? numbers[0] : numbers[1];
		int secondMax = (numbers[0] < numbers[1]) ? numbers[0] : numbers[1];
		for (int number : numbers) {
			if (number > max) {
				secondMax = max;
				max = number;
			} else if (number > secondMax && number != max) {
				secondMax = number;
			}
		}
		return secondMax;
	}

	private static void sort(int[] numbers) {
		for (int out = numbers.length - 1; out > 0; out--) {
			for (int in = 0; in <= out; in++) {
				if (numbers[in] > numbers[out]) {
					int tmp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = tmp;
				}
			}
		}
	}

	private static int[] insert(int[] numbers, int k, int insertNumber) {
		int length = numbers.length + 1;
		int[] newNumbers = new int[length];
		if (k >= 0 && k < numbers.length) {
			for (int i = 0; i < length; i++) {
				if (i < k) {
					newNumbers[i] = numbers[i];
				} else if (i == k) {
					newNumbers[i] = insertNumber;
				} else {
					newNumbers[i] = numbers[i - 1];
				}
			}
		}
		return newNumbers;
	}

	private static int[] insertV2(int[] numbers, int k, int insertNumber) {
		int length = numbers.length + 1;
		int[] newNumbers = new int[length];
		if (k >= 0 && k < numbers.length) {
			for (int i = 0; i < numbers.length; i++) {
				newNumbers[i] = numbers[i];
			}
			for (int i = length - 1; i > k; i--) {
				newNumbers[i] = newNumbers[i - 1];
			}
			newNumbers[k] = insertNumber;
		}
		return newNumbers;
	}
}
