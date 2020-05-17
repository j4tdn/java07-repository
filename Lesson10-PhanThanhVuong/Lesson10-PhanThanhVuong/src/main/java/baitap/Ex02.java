package baitap;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[] number = { 11, 33, 77, 77, 77, 71, 66, 22, 0 };
		System.out.println(secondMax(number));
		sort(number);
		Arrays.stream(number).forEach(numbers -> System.out.print(numbers + " "));
		System.out.println();
		insert(number, 2, 100);
		Arrays.stream(number).forEach(numbers -> System.out.print(numbers + " "));
	}

	private static int[] printEvenNumbers(int[] numbers) {
		int lenght = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				lenght++;
			}
		}
		int[] evenNumbers = new int[lenght];
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

	private static int secondMax(int[] numbers) {
		int max = 0;
		int secondMax = 0;
		max = (numbers[0] > numbers[1]) ? numbers[0] : numbers[1];
		secondMax = (numbers[0] > numbers[1]) ? numbers[1] : numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (max < numbers[i]) {
				max = numbers[i];
			} else if (numbers[i] != max && secondMax < numbers[i]) {
				secondMax = numbers[i];
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

	private static int[] insert(int[] arr, int index, int value) {
		int[] result = new int[arr.length + 1];
		for (int i = 0; i < index; i++) {
			result[i] = arr[i];
		}
		result[index] = value;
		for (int i = index; i < arr.length; i++) {
			result[i + 1] = arr[i];
		}
		return result;
	}

	private static int[] insert2(int[] number, int index, int value) {
		int[] result = new int[number.length + 1];
		for (int i = 0; i < number.length; i++) {
			result[i] = number[i];
		}
		return result;
	}
}
