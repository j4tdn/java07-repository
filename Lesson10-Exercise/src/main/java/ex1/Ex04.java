package ex1;

import java.util.Arrays;

public class Ex04 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 5, 8, 4, 5, 4, 2, 1};
		Arrays.sort(numbers);
		numbers = Ex01.distinct(numbers);
		System.out.println(numbers[numbers.length - 3]);
	}
}
