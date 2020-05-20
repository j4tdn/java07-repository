package exercises;

import java.util.Arrays;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = initializeArray(10);

		System.out.println("=========Initialize A Random Numbers===========");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));

		System.out.println("\n=========Get Unique Numbers===========");
		int[] numbers1 = getUniqueNumbers(numbers);
		Arrays.stream(numbers1).forEach(number1 -> System.out.print(number1 + " "));

		System.out.println("\n=========Compare The Average of first 5 Numbers And Last 5 Numbers===========");
		System.out.println(compareAverage(numbers));

		System.out.println("\n=========Insertion Sort===========");
		sort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));

		System.out.println("\n=========The Third Max Number===========");
		System.out.println(findTheThirdMaxNumbers(numbers));
	}

	private static int[] initializeArray(int n) {
		int[] array = new int[n];
		Random rd = new Random();

		for (int i = 0; i < n; i++) {
			int rand = rd.nextInt(100);
			array[i] = rand;
		}
		return array;
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;

		for (int number : numbers) {
			if (isUniqueNumber(numbers, number)) {
				result[index++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isUniqueNumber(int[] numbers, int input) {
		int count = 0;

		for (int number : numbers) {
			if (number == input) {
				count++;
				if (count > 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static String compareAverage(int[] numbers) {
		int firstAve = 0;
		int secondAve = 0;
		int firstSum = 0;
		int secondSum = 0;

		for (int i = 0; i < 5; i++) {
			firstSum += numbers[i];
			secondSum += numbers[i + 5];
		}
		firstAve = firstSum / 5;
		secondAve = secondSum / 5;
		return firstAve - secondAve > 0 ? "The average of first 5 numbers > The average of last 5 numbers"
				: "The average of first 5 numbers < The average of last 5 numbers";
	}

	// Insertion Sort
	private static void sort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int key = numbers[i];
			int j = i - 1;
			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j = j - 1;
			}
			numbers[j + 1] = key;
		}
	}

	private static int findTheThirdMaxNumbers(int[] numbers) {
		sort(numbers);
		int index = numbers.length - 1;
		int thirdMax = 0;

		while (index > 0) {
			if (numbers[index - 2] != numbers[index - 1] && numbers[index - 2] != numbers[index]) {
				thirdMax = numbers[index - 2];
				break;
			}
			index--;
		}
		return thirdMax;
	}
}
