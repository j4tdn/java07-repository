package sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers = { 5, 1, 3, 9, 8, 3, 2, 1, 4, 6 };
		selectionSort(numbers);
	}

	private static void selectionSort(int[] numbers) {
		System.out.println("Given Array"); 
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		for (int step = 0; step < numbers.length - 1; step++) {
			int minIndex = step + 1;
			for (int j = step + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[minIndex]) {
					minIndex = j;
				}
			}
			int tmp = numbers[step];
			numbers[step] = numbers[minIndex];
			numbers[minIndex] = tmp;
		}
		System.out.println("\nSorted array: ");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}
}