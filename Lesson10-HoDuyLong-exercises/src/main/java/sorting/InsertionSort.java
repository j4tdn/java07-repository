package sorting;

import java.util.Arrays;
import java.util.Random;

import common.Sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = initializeArray(10);

		insertionSort(numbers, Sort.ASCE);
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

	private static void insertionSort(int[] numbers, Sort sort) {
		for (int i = 1; i < numbers.length; i++) {
			int key = numbers[i];
			int j = i - 1;

			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = key;
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
