package sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String args[]) {
		int[] numbers = { 5, 1, 3, 9, 8, 3, 2, 1, 4, 6 };
		mergeSort(numbers);
	}

	private static void mergeSort(int[] numbers) {
		System.out.println("Given Array");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));

		sort(numbers, 0, numbers.length - 1);

		System.out.println("\nSorted array");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}

	private static void sort(int[] numbers, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(numbers, left, mid);
			sort(numbers, mid + 1, right);
			merge(numbers, left, mid, right);
		}
	}

	private static void merge(int[] numbers, int left, int mid, int right) {
		int lenLeft = mid - left + 1;
		int lenRight = right - mid;

		int leftArray[] = new int[lenLeft];
		int rightArray[] = new int[lenRight];

		for (int i = 0; i < lenLeft; ++i)
			leftArray[i] = numbers[left + i];
		for (int j = 0; j < lenRight; ++j)
			rightArray[j] = numbers[mid + 1 + j];

		int indexLeft = 0, indexRight = 0;
		int index = left;

		while (indexLeft < lenLeft && indexRight < lenRight) {
			if (leftArray[indexLeft] <= rightArray[indexRight]) {
				numbers[index] = leftArray[indexLeft];
				indexLeft++;
			} else {
				numbers[index] = rightArray[indexRight];
				indexRight++;
			}
			index++;
		}

		while (indexLeft < lenLeft) {
			numbers[index] = leftArray[indexLeft];
			indexLeft++;
			index++;
		}

		while (indexRight < lenRight) {
			numbers[index] = rightArray[indexRight];
			indexRight++;
			index++;
		}
	}
}
