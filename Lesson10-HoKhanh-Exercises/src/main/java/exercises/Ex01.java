package exercises;

import java.util.Arrays;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rd.nextInt(10);
		}
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.print("\nmang sau khi loai phan tu trung: ");
		Arrays.stream(getUniNumbers(numbers)).forEach(number -> System.out.print(number + " "));
		System.out.println();
		compareAverage(numbers);
		System.out.print("\nmang sau khi sap xep: ");
		insertionSort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println();
		thirdNumberMax(numbers);
	}

	private static void thirdNumberMax(int[] numbers) {
		insertionSort(numbers);
		int count=0;
		for (int i = numbers.length - 1; i > 0; i--) {
			if (numbers[i] != numbers[i - 1]) {
				count++;
				if(count==2) {
					System.out.println("so lon thu 3: "+numbers[i-1]);
				}
			}
		}
	}

	private static void insertionSort(int[] numbers) {
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

	private static void compareAverage(int[] numbers) {
		double averageFirst = 0, averageLast = 0;
		int sumFirst = 0, sumLast = 0;
		for (int i = 0; i < 5; i++) {
			sumFirst += numbers[i];
			sumLast += numbers[i + 5];
		}
		averageFirst = (double) sumFirst / 5;
		averageLast = (double) sumLast / 5;
		if (averageFirst < averageLast) {
			System.out.println("gia tri trung binh 5 phan tu dau = " + averageFirst
					+ " be hon gia tri trung binh 5 phan tu cuoi =" + averageLast);
		} else if (averageFirst > averageLast) {
			System.out.println("gia tri trung binh 5 phan tu dau = " + averageFirst
					+ " lon hon gia tri trung binh 5 phan tu cuoi = " + averageLast);
		} else {
			System.out.println("gia tri trung binh 5 phan tu dau = " + averageFirst
					+ " bang gia tri trung binh 5 phan tu cuoi = " + averageLast);
		}
	}

	private static int[] getUniNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int k = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (!isUnique(numbers[i], numbers, i)) {
				result[k] = numbers[i];
				k++;
			}
		}

		return Arrays.copyOfRange(result, 0, k);
	}

	private static boolean isUnique(int number, int[] result, int index) {
		for (int i = 0; i < result.length; i++) {
			if (index != i && number == result[i]) {
				return true;
			}
		}
		return false;
	}
}
