package view;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		int[] intNumbers = { 1, 6, 3, 4, 6, 3, 7, 0, 0, 2, 5, 9, 2, 8, 4 };

		int[] arrNew = distinct(intNumbers);
		Arrays.stream(arrNew).forEach(number -> System.out.print(number + " "));
		System.out.println("\n---------");

		int[] arrIntNumber = getUniqueNumber(intNumbers);
		Arrays.stream(arrIntNumber).forEach(number -> System.out.print(number + " "));
		System.out.println("\n---------");

		int[] arrayNumbers = getUniqueNumber1(intNumbers);
		Arrays.stream(arrayNumbers).forEach(number -> System.out.print(number + " "));
	}

	private static int[] distinct(int[] intNumbers) {
		int[] arrNew = new int[intNumbers.length];
		int index = 0;
		for (int i = 0; i < intNumbers.length; i++) {
			if (contains(intNumbers, i)) {
				arrNew[index++] = intNumbers[i];
			}
		}
		return Arrays.copyOfRange(arrNew, 0, index);
	}

	private static boolean contains(int[] intNumbers, int index) {
		for (int i = 0; i < index; i++) {
			if (intNumbers[i] == intNumbers[index]) {
				return false;
			}
		}
		return true;
	}

	private static int[] getUniqueNumber(int[] intNumbers) {
		int[] arrNew = new int[intNumbers.length];
		int temp = 0;
		for (int i = 0; i < intNumbers.length; i++) {
			if (isUnique(intNumbers, i)) {
				arrNew[temp++] = intNumbers[i];
			}
		}
		return Arrays.copyOfRange(arrNew, 0, temp);
	}

	private static boolean isUnique(int[] intNumbers, int index) {
		for (int i = 0; i < intNumbers.length; i++) {
			if (intNumbers[i] == intNumbers[index] && i != index) {
				return false;
			}
		}
		return true;
	}

	private static int[] getUniqueNumber1(int[] intNumbers) {
		boolean[] arrNew = new boolean[intNumbers.length];
		int[] result = new int[intNumbers.length];
		Arrays.fill(arrNew, true);
		int temp = 0;
		for (int i = 0; i < intNumbers.length; i++) {
			if (arrNew[i]) {
				isUnique1(intNumbers, arrNew, i);
			}
			if (arrNew[i]) {
				result[temp++] = intNumbers[i];
			}
		}
		return Arrays.copyOfRange(result, 0, temp);
	}

	private static void isUnique1(int[] intNumbers, boolean[] arrNew, int index) {
		for (int i = index + 1; i < intNumbers.length; i++) {
			if (intNumbers[i] == intNumbers[index]) {
				arrNew[i] = false;
				arrNew[index] = false;
			}
		}
	}
}