package ex1;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 5, 8, 9, 10, 5, 8, 9, 12, 7, 7, 6};
		sort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.println(number + " "));
	}
	
	private static void sort(int[] numbers) {
		for (int out = 0; out < numbers.length - 1; out++) {
			for (int in = out + 1; in < numbers.length; in++) {
				if (numbers[out] > numbers[in]) {
					int temp = numbers[out];
					numbers[out] = numbers[in];
					numbers[in] = temp;
				}
			}
		}
	}
}
