package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = initializeArray(10);

		quickSort(numbers, 0, 9);
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

	private static void quickSort(int[] numbers, int l, int h) {
		if (l < h) {
			int pivot = partition(numbers, l, h);

			quickSort(numbers, l, pivot - 1);
			quickSort(numbers, pivot + 1, h);
		}
	}

	private static int partition(int[] arr, int l, int h) {
		int pivot = arr[h];
		int i = l - 1;

		for (int j = l; j < h; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[h];
		arr[h] = temp;

		return i + 1;
	}
}
