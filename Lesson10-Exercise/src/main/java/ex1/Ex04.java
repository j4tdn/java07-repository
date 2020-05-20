package ex1;

import java.util.Arrays;

public class Ex04 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 5, 8, 4, 5, 4, 2, 1};
		Arrays.sort(numbers);
		System.out.println(distinct(numbers)[distinct(numbers).length - 3]);
	}
	
	private static int[] distinct(int[] numbers) {
		int[] results = new int[numbers.length];
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (!contains(results, numbers[i], i)) {
				results[index++] = numbers[i];
			}
		}
		return Arrays.copyOfRange(results, 0, index);
	}

	private static boolean contains(int[] results, int number, int index) {
		for (int i = 0; i < index; i++) {
			if (number == results[i]) {
				return true;
			}
		}
		return false;
	}
}
