package sorting;

import java.util.Arrays;
import java.util.Random;

import common.Sort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers = initializeArray(10);

		selectionSort(numbers, Sort.DESC);
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

	private static void selectionSort(int[] numbers, Sort sort) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[minIndex]) {
					minIndex = j;
				}
			}
			int temp = numbers[minIndex];
			numbers[minIndex] = numbers[i];
			numbers[i] = temp;
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
