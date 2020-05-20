package exercise;

import java.util.Arrays;

public class Bt01 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 3, 1, 5, 8, 2, 7 };
		getUniqueNumbers(numbers);
		Arrays.stream(getUniqueNumbers(numbers)).forEach(number -> System.out.print(number + " "));
		System.out.println("====================================");
		double numberA = tbFirt(numbers, 1, 5);
		double numberB = tbFirt(numbers, 6, 10);
		if (Double.compare(numberA, numberB) == 0) {

			System.out.println("bang nhau");
		} else if (Double.compare(numberA, numberB) < 0) {

			System.out.println("numberA < number B");
		} else {

			System.out.println("numberA>numberB");
		}
		System.out.println("numberA : " + numberA);
		System.out.println("numberB : " + numberB);
		System.out.println("==============================");
		insertionSort(numbers);
		System.out.println("==============================");
		maxNumber3(numbers);

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

	private static boolean contains(int[] result, int number, int valueNumberIndex) {
		for (int i = 0; i < valueNumberIndex; i++) {
			if (result[i] == number) {
				return true;
			}
		}
		return false;
	}

	private static double tbFirt(int[] numbers, int a, int b) {
		double sum = 0;
		for (int i = a - 1; i < b; i++) {
			sum += numbers[i];
		}
		return sum / (b - a + 1);

	}

	private static void insertionSort(int[] numbers) {

		for (int i = 1; i < numbers.length; ++i) {
			int key = numbers[i];
			int j = i - 1;

			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j = j - 1;
			}
			numbers[j + 1] = key;
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	private static void maxNumber3(int[] numbers) {
		int max=0;
		int max2=0;
		int max3=0;
		for(int number : numbers) {
			if(number>max) {
				max=number;
			}
		}
		for(int number : numbers) {
			if(max==number) {
				continue;
			}
			else if(max2<number) {
				max2=number;
			}
		}
		for(int number : numbers) {
			if(max==number) {
				continue;
			}
			else if(max2==number) {
				continue;
			}
			else if(max3<number){
				max3=number;
			}
		}
		System.out.println(max3);
	}

}
