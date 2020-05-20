package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {
		int[] numbers = initializeArray(10);

		mergeSort(numbers, 0, 9);
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

	private static void mergeSort(int[] numbers, int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(numbers, l, m);
			mergeSort(numbers, m + 1, r);

			// Merge the sorted halves
			merge(numbers, l, m, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		int[] L = new int[n1];
		int[] R = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}

		// Merge the temp arrays
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;
		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
