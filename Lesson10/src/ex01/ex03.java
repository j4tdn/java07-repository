package ex01;

import java.awt.Container;
import java.util.Arrays;

public class ex03 {
	// 1 6 3 4 6 3 7
	// distinct: loại bỏ những phần tử trùng nhau đ/a: 1 6 3 4 7
	// getUniqueNumbers: 1 4 7 Những phần tử chỉ xuất hiện một lần.

	public static void main(String[] args) {
		int[] numbers = { 1, 6, 0, 3, 4, 6, 3, 7 };
//		for (int i : distinct(numbers)) {
//			System.out.print(i + " ");
//		}
//		Arrays.stream(numbers).distinct().forEach(num -> System.out.print(num + " "));
//		System.out.println();
		numbers=getUniqueNumbers(numbers);
		Arrays.stream(numbers).distinct().forEach(num -> System.out.print(num + " "));
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
		/*
		 * cách 1: 
		 * for (int number : numbers) { if (isUnique(numbers, number)) {
		 * result[index++]=number; } }
		 */
		// cách 2: 2 for
		/*
		 * for (int out = 0; out < numbers.length; out++) { int count=1; for (int in =
		 * 0; in < numbers.length; in++) { if (out!=in && numbers[in]==numbers[out]) {
		 * count++; break; } } if (count ==1) { result[index++]=numbers[out]; } }
		 */
		// cach 3: gắn cờ.
		boolean[] flags = new boolean[numbers.length];
		Arrays.fill(flags, true);
		for (int i = 0; i < numbers.length; i++) {
			if (flags[i]) {
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[i] == numbers[j]) {
						flags[i] = false;
						flags[j] = false;
					}
				}
			}
			if (flags[i]) {
				result[index++]=numbers[i];
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isUnique(int[] numbers, int input) {
		int count = 0;
		for (int i : numbers) {
			if (i == input) {
				count++;
				if (count == 2) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[] distinct(int[] numbers) {
		int[] result = new int[numbers.length];
		int i = 0;
		for (int number : numbers) {
			if (!contain(result, number, i)) {
				result[i++] = number;
			}
		}

		return Arrays.copyOfRange(result, 0, i);
	}

	private static boolean contain(int[] result, int number, int validNumberIndex) {
		for (int i = 0; i < validNumberIndex; i++) {
			if (result[i] == number) {
				return true;
			}
		}
		return false;
	}
}
