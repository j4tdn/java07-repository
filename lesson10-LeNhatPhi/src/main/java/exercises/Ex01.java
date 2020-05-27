package exercises;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 4, 3, 5, 1 };
		numbers = getUnitque(numbers);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + "  "));

		System.out.println("\n===============================");
		double[] numbers1 = { 1, 2, 3, 4, 4, 3, 5, 1 };
		averageNumber(numbers1);

		System.out.println("\n===============================");
		int[] numbers2 = { 1, 2, 3, 4, 4, 3, 5, 1 };
		insertionSort(numbers2);
		Arrays.stream(numbers2).forEach(num -> System.out.print(num + "  "));

	

		System.out.println("\n===============================");
		int[] numbers4 = { 1, 5, 2, 5, 4, 6 };
		System.out.println("Arrays:  1, 5, 2, 5, 4, 6 ");
		System.out.println("THree Max Array:   " +threeMaxNumber(numbers4, 6));

	}

//Ex01
	private static int[] getUnitque(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
		for (int number : numbers) {
			if (isUniq(numbers, number)) {
				result[index++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isUniq(int[] numbers, int input) {
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

//Ex02 
	private static void averageNumber(double[] numbers1) {
		double average1 = 0;
		double average2 = 0;
		for (int in = 0; in <= 5; in++) {
			for (int out = numbers1.length - 1; out >= 5; out--) {
				average1 += in;
				average2 += out;
			}
		}
		average1 = average1 / 5;
		average2 = average2 / 5;
		if (average1 == average2) {
			System.out.println("Bằng nhau");
		} else {
			if (average1 > average2) {
				System.out.println("Trung Bình 5 phần tử đầu lớn hơn 5 phần tử sau");
			} else {
				System.out.println("Trung Bình 5 phần tử đầu bé hơn 5 phần tử sau");
			}
		}
	}

//Ex03
	private static void insertionSort(int[] numbers2) {
		for (int i = 0; i < numbers2.length; i++) {
			int result = numbers2[i];
			int j = i;
			while (j > 0 && numbers2[j - 1] > result) {
				numbers2[j] = numbers2[j - 1];
				j--;
			}
			numbers2[j] = result;
		}
	}

//Ex04
	private static int threeMaxNumber(int[] numbers4, int totalArrays) {
		Arrays.sort(numbers4);
		return numbers4[totalArrays - 4];
	}
}
