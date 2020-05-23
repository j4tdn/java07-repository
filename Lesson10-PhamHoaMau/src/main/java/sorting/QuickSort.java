package sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = { 5, 1, 3, 9, 8, 3, 2, 1, 4, 6 };
		quickSort(numbers);
	}

	private static void quickSort(int[] numbers) {
		System.out.println("Given Array");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		sort(numbers, 0, numbers.length - 1);
		System.out.println("\nSorted array: ");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}

	private static void sort(int[] numbers, int in, int out) {
		if (in < out) {
			int pivotIndex = partition(numbers, in, out);

			sort(numbers, in, pivotIndex - 1);
			sort(numbers, pivotIndex + 1, out);
		}
	}

	private static int partition(int[] numbers, int in, int out) {
		int pivot = numbers[out];
		int indexSmallerElement = (in - 1);
		for (int index = in; index < out; index++) {
			if (numbers[index] < pivot) {
				indexSmallerElement++;
				int temp = numbers[indexSmallerElement];
				numbers[indexSmallerElement] = numbers[index];
				numbers[index] = temp;
			}
		}

		int temp = numbers[indexSmallerElement + 1];
		numbers[indexSmallerElement + 1] = numbers[out];
		numbers[out] = temp;
		return indexSmallerElement + 1;
	}
}
