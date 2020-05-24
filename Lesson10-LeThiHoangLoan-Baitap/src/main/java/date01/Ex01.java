package date01;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 1, 4, 5, 23, 5, 54, 32, 1, 5, 21 };
		int[] result = getUniqueNumbers(numbers);
		Arrays.stream(result).forEach(num -> System.out.print(num + " "));
		System.out.println("\n==============");
		
		compare(numbers);

		int[] resultOfCompare = insertionSort(numbers);
		Arrays.stream(resultOfCompare).forEach(num -> System.out.print(num + " "));

		int[] uniqueSort = insertionSort(result);
		System.out.println("\nSo lon thu 3: " + uniqueSort[result.length - 3]);

	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		boolean[] flags = new boolean[numbers.length];
		int index = 0;

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
			if (flags[i] == true) {
				result[index++] = numbers[i];
			}
		}

		return Arrays.copyOfRange(result, 0, index);

	}

	private static void compare(int[] numbers) {
		int sum1 = 0;
		int sum2 = 0;
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (count < 5) {
				sum1 += numbers[i];
				count++;
			}
			count = 0;
			if (count < 5) {
				sum2 += numbers[i];
				count++;
			}
		}
		if ((float) sum1 / 5 > (float) sum2 / 5) {
			System.out.println("tbc 5 so dau lon hon");
		} else {
			System.out.println("tbc 5 so sau lon hon");
		}
	}

	private static int[] insertionSort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int tmp = numbers[i];
			int j = i;
			while (j > 0 && numbers[j - 1] > tmp) {
				numbers[j] = numbers[j - 1];
				j--;
			}
			numbers[j] =tmp;
		}
		return numbers;

	}

}
