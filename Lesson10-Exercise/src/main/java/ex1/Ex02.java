package ex1;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 5, 8, 9, 10, 5, 8, 9, 12, 7, 7, 6};
		float a = average(Arrays.copyOfRange(numbers, 0, 4));
		float b = average(Arrays.copyOfRange(numbers, numbers.length - 5, numbers.length - 1));
		if (a > b) {
			System.out.println("a > b");
		} else if (a < b) {
			System.out.println("a < b");
		} else {
			System.out.println("a = b");
		}
		
	}
	
	private static float average(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum / numbers.length;
	}
	
}
