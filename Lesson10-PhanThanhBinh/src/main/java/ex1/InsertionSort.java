package ex1;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 5, 8, 9, 10, 5, 8, 9, 12, 7, 7, 6};
		sort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.println(number + " "));
	}
	
	private static void sort(int[] numbers) {
		for (int out = 1; out < numbers.length - 1; out++) {
			int key = numbers[out];
			int in = out - 1;
			while (in >= 0 && numbers[in] > key) {
				numbers[in + 1] = numbers[in];
				in = in - 1;
			}
			numbers[in + 1] = key;
		} 
	}
}
