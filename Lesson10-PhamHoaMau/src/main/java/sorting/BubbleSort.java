package sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] numbers = { 5, 1, 3, 9, 8, 3, 2, 1, 4, 6 };
		bubbleSort(numbers);
	}

	private static void bubbleSort(int[] numbers) {
		int swapped = 0;
		System.out.println("Given Array");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		do {
			swapped = 0;
			for (int index = 1; index < numbers.length; index++) {
				if (numbers[index - 1] > numbers[index]) {
					int tmp = numbers[index - 1];
					numbers[index - 1] = numbers[index];
					numbers[index] = tmp;
					swapped = 1;
				}
			}
		} while (swapped == 1);
		System.out.println("\nSorted Array: ");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}
}
