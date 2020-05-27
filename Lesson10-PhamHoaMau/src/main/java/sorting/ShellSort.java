package sorting;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] numbers = { 5, 1, 3, 9, 8, 3, 2, 1, 4, 6 };
		shellSort(numbers);
	}

	private static void shellSort(int[] numbers) {
		System.out.println("Given Arrays: ");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
			for (int index = gap; index < numbers.length; index += 1) {
				//swap
				int temp = numbers[index];
				int shellStep;
				for (shellStep = index; shellStep >= gap && numbers[shellStep - gap] > temp; shellStep -= gap) {
					numbers[shellStep] = numbers[shellStep - gap];
				}
				numbers[shellStep] = temp;
			}
		}
		System.out.println("\nSorted Arrays: ");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
	}
}
