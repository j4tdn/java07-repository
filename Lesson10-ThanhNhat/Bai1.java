package BTDATE01;

import java.util.Arrays;
import java.util.Random;

public class Bai1 {
	private static int index = 5;

	public static void main(String[] args) {
		Random rd = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rd.nextInt(10) + 1;
			System.out.print(numbers[i] + "  ");
		}

		System.out.println();
		
		System.out.print("Unique Numbers: ");
		int[] uniqueNumbers = getUniqueNumbers(numbers);
		Arrays.stream(uniqueNumbers).distinct().forEach(number -> System.out.print(number + "  "));

		System.out.println();

		System.out.print("Compare: ");
		System.out.println(getAvg(numbers, 0, index) > getAvg(numbers, index, numbers.length) ? Compare.IsGreater
				: Compare.IsSmaller);

		System.out.print("Insertion Sort: ");
		insertionSort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + "  "));
		
		System.out.println();
		
		System.out.println("The third-max number: "+thirdMax(numbers));

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
						flags[out] = false;
						flags[in] = false;
					}
				}

				if (flags[out]) {
					result[index++] = numbers[out];
				}
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static double getAvg(int[] numbers, int from, int to) {
		double s = 0;
		for (int number : Arrays.copyOfRange(numbers, from, to)) {
			s += number;
		}
		return s / (to - from);
	}

	private static void insertionSort(int numbers[]) {
		int i, key, j;
		for (i = 1; i < numbers.length; i++) {
			key = numbers[i];
			j = i - 1;
			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j = j - 1;
			}
			numbers[j + 1] = key;
		}
	}
	
	private static int thirdMax(int[] numbers) {
		int count=0;
		for (int i=0;i<numbers.length-1;i++) {
			if(numbers[i]!=numbers[i+1]) {
				count++;
			}
			if (count==3) return numbers[i];
		}
		return -1;
	}
}
