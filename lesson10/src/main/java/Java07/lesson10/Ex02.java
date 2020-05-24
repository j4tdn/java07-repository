package Java07.lesson10;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		// 1 6 3 4 6 3
		// distinct : loai bo cac phan tu trung nhau
		// getUniqueNumbers :1,4,7 cac phan tu chi xuat hien 1 lan
		int[] numbers = { 1, 6, 3, 4, 6, 3 };

		// System.out.println();
		// distinct(numbers);
		// getUniqueNumber(numbers);
		// Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		// Arrays.stream(numbers).distinct().forEach(number -> System.out.print(number +
		// " "));
		getUniqueNumbers(numbers);
		Arrays.stream(getUniqueNumbers(numbers)).forEach(number-> System.out.print(number + " "));

	}
	// 3rd way

	private static int[] distinct(int[] numbers) {

		int[] result = new int[numbers.length];

		int i = 0;
		for (int number : numbers) {
			if (!contains(result, number, i)) {
				result[i++] = number;
			}
		}

		return Arrays.copyOfRange(result, 0, i);

	}

	private static boolean contains(int[] result, int number, int valueNumberIndex) {
		for (int i = 0; i < valueNumberIndex; i++) {

			if (result[i] == number) {
				return true;
			}

		}
		return false;
	}

	private static boolean contains1(int[] result, int number) {
		for (int item : result) {

			if (item == number) {
				return true;
			}

		}
		return false;
	}

	private static int[] getUniqueNumber(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
		for (int number : numbers) {
			if (isUnique(numbers, number)) {
				result[index] = number;

			}
		}
		return Arrays.copyOfRange(result, 0, index); // copy vao mang khac
	}

	private static boolean isUnique(int[] numbers, int input) {
		int count = 0;
		for (int number : numbers) {
			if (number == input) {
				count++;
				if (count == 2) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;

		boolean[] flags = new boolean[numbers.length];
		Arrays.fill(flags, true);
		for (int out = 0; out < numbers.length; out++) {
			if (flags[out]) {
				for (int in = out + 1; in < numbers.length; in++) {
					if (numbers[out] == numbers[in]) {
						flags[in] = false;
						flags[out] = false;
					}
				}
				if (flags[out]) {
					result[index++] = numbers[out];
				}
			}

		}
		return Arrays.copyOfRange(result, 0, index);
	}

}
