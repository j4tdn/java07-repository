package baitap;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 3, 4, 5, 6, 6 };
		distinct(numbers);
		// Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		int[] arr = distinct(numbers);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		Arrays.stream(numbers).distinct().forEach(num -> System.out.print(num + "\t"));

	}

	private static int[] distinct(int[] numbers) {
		int[] result = new int[numbers.length];
		int i = 0;
		for (int number : numbers) {
			if (!isContain(result, number, i)) {
				result[i++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}

	private static boolean isContain(int[] result, int number, int validNumberIndex) {
		for (int i = 0; i < validNumberIndex; i++) {
			if (result[i] == number) {
				return true;
			}
		}
		return false;
	}

	private static int[] xoa1(int arr[]) {
		int[] a = new int[arr.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = arr[i];
		}
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {

			for (int k = i + 1; k < n; k++)

				if (a[k] == a[i])

				{

					for (int j = k; j < n - 1; j++)

						a[j] = a[j + 1];

					n--;

					k--;

				}
		}
		return a;

	}

}
