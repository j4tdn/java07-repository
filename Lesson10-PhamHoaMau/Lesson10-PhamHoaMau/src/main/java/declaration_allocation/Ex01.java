package declaration_allocation;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 100, 3, 100, 9, 10, 5, 6, 78 };

		printEvenNumber(numbers);

		totalOfOddNumbers(numbers);

		maxAndSecondMaxValueOfArray(numbers);

		sortArray(numbers);

		bubbleSort(numbers);

		insertElementsIntoArray(numbers, 5, 111);

		delElementOfArray(numbers, 6);

	}

	private static int[] delElementOfArray(int[] numbers, int k) {
		if (k < 0 || k > numbers.length - 1) {
			System.out.println("\nDelete a element of array: ");
			Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
			return numbers;
		}
		int[] results = new int[numbers.length - 1];
		for (int i = 0; i < k; i++) {
			results[i] = numbers[i];
		}
		for (int i = k; i < results.length; i++) {
			results[i] = numbers[i + 1];
		}
		System.out.println("\nDelete a element of array: ");
		Arrays.stream(results).forEach(number -> System.out.print(number + " "));
		return results;
	}

	private static int[] insertElementsIntoArray(int[] numbers, int k, int value) {
		if (k < 0 || k > numbers.length - 1) {
			return numbers;
		}
		int[] results = new int[numbers.length + 1];
		for (int i = 0; i < k; i++) {
			results[i] = numbers[i];
		}
		results[k] = value;
		for (int i = k; i < results.length - 1; i++) {
			results[i + 1] = numbers[i];
		}
		System.out.println("\nInsert a element into array: ");
		Arrays.stream(results).forEach(number -> System.out.print(number + " "));
		return results;
	}

	private static void bubbleSort(int[] numbers) {
		for (int out = numbers.length - 1; out >= 0; out--) {
			for (int in = 0; in <= out; in++) {
				if (numbers[in] > numbers[out]) {
					int temp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = temp;
				}
			}
		}
		System.out.println("\nBubble sort: ");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}

	private static void sortArray(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		System.out.println("Sort: ");
		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}

	private static void maxAndSecondMaxValueOfArray(int[] numbers) {
		int max = (numbers[0] > numbers[1]) ? numbers[0] : numbers[1];
		int secondMax = (numbers[0] > numbers[1]) ? numbers[1] : numbers[0];
		for (int number : numbers) {
			if (number > max) {
				secondMax = max;
				max = number;
			} else {
				if (number != max && number > secondMax) {
					secondMax = number;
				}
			}
		}
		System.out.println("Max: " + max + "\nSecond Max: " + secondMax);
	}

	private static int maxValueOfArray(int[] numbers) {
		int max = numbers[0];
		for (int number : numbers) {
			if (max < number) {
				max = number;
			}
		}
		System.out.println("Max value of array: " + max);
		return max;
	}

	private static void totalOfOddNumbers(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number % 2 == 1) {
				sum += number;
			}
		}
		System.out.println("Total of Odd Number : " + sum);
	}

	private static int[] printEvenNumber(int[] numbers) {
		System.out.print("Even Number of Array: ");
		int count = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				count++;
			}
		}
		int[] evenNumbers = new int[count];
		int index = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				evenNumbers[index] = number;
				index++;
			}
		}
		for (int number : evenNumbers) {
			System.out.print(number + " ");
		}
		System.out.println();
		return evenNumbers;
	}
}
