package sorting;

import java.util.Arrays;
import java.util.Random;

import common.Sort;

public class BubbleSort {
	public static void main(String[] args) {
		int[] numbers = initializeArray(10);

		bubbleSort(numbers, Sort.DESC);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}

	private static int[] initializeArray(int n) {
		int[] array = new int[n];
		Random rd = new Random();

		for (int i = 0; i < n; i++) {
			int rand = rd.nextInt(100) + 1;
			array[i] = rand;
		}
		return array;
	}

	private static void bubbleSort(int[] numbers, Sort sort) {
		boolean swapped;
		for (int i = 0; i < numbers.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
		if (Sort.DESC.equals(sort)) {
			reverse(numbers);
		}
	}

	private static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}
}
