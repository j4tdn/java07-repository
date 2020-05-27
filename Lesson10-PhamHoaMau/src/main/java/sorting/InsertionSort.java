package sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = { 5, 1, 3, 9, 8, 3, 2, 1, 4, 6 };
		insertionSort(numbers);
	}

	private static void insertionSort(int[] numbers) {
		System.out.println("Given Arrays: "); 
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		for (int index = 1; index < numbers.length; index++) {
			if (numbers[index - 1] > numbers[index]) {
				int key = numbers[index];
				int indexInsertion = index - 1;
				while (indexInsertion >= 0 && key < numbers[indexInsertion]) {
					numbers[indexInsertion + 1] = numbers[indexInsertion];
					indexInsertion -= 1;
				}
				numbers[indexInsertion + 1] = key;
			}
		}
		System.out.println("\nSorted Arrays: ");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}
}
