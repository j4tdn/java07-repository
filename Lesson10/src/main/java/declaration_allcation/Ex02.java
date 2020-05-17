package declaration_allcation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {
		System.out.println("=================");
		int[] numbers = { 11, 22, 33, 44, 55, 2 };
		// 1
		int[] eventNumber = printEventNumber(numbers);
		for (int number : eventNumber) {
			System.out.println(number);
		}
		// 2
		System.out.println("Total : " + totalOfOddNumber(numbers));
		// 3
		numbers[0] = 199;
		// 4
		System.out.println("Max : " + max(numbers));
		System.out.println("SecondMax : " + secondMax(numbers));
		// 5.Sắp xếp
		sort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);
		//
		System.out.println("=====================");
		int[] newNumbers = insert(numbers, 2, 99);
		for (int number : newNumbers) {
			System.out.println(number);
		}
		//
		System.out.println("=====================");
		int[] result = delete(numbers, 2);
		for (int number : result) {
			System.out.println(number);
		}
	}

	private static int[] printEventNumber(int[] numbers) {

		int length = 0;

		for (int number : numbers) {
			if (number % 2 == 0) {
				length++;

			}
		}
		int[] eventNumber = new int[length];
		int index = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				eventNumber[index++] = number;

			}
		}
		return eventNumber;
	}

	private static int totalOfOddNumber(int[] numbers) {
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
			if (number > max) {
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
			} else if (number > secondMax && number != max) {
				secondMax = number;
			}
		}
		return secondMax;

	}

	// 2 5 3 6 1
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

		//độ dài mảng ko thể thay đổi
	private static int[] insert(int[] numbers, int k, int number) {
		int[] newNumbers = new int[numbers.length + 1];
		for (int i = 0; i < newNumbers.length; i++) {
			if (i < k - 1) {
				newNumbers[i] = numbers[i];

			} else if (i == k - 1) {
				newNumbers[i] = number;

			} else {
				newNumbers[i] = numbers[i - 1];
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
	
	private static int[] delete(int[] numbers, int k) {
		int[] newNumbers = new int[numbers.length - 1];
		for (int i = 0; i < newNumbers.length; i++) {
			if (i < k - 1) {
				newNumbers[i] = numbers[i];
			} else if (i >= k - 1) {
				newNumbers[i] = numbers[i + 1];
			}
		}

		return newNumbers;

	}

}