package ex1;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = {0, 1, 2, 4, 3, 1, 3, 0, 0, 0 };
		Arrays.stream(distinct(digits)).forEach(digit -> System.out.println(digit + " "));
	}

	public static int[] getUniqueNumbers(int[] digits) {
		int[] result = new int[digits.length];
		int index = 0;
		for (int i = 0; i < digits.length; i++) {
			if (contains(digits, digits[i], i)) {
				result[index++] = digits[i];
			}
		}

		return Arrays.copyOfRange(result, 0, index);
	}
	
	public static int[] distinct(int[] digits) {
		int[] result = new int[digits.length];
		int index = 0;
		for (int i = 0; i < digits.length; i++) {
			if (contains(result, digits[i], index)) {
				result[index++] = digits[i];
			}
		}

		return Arrays.copyOfRange(result, 0, index);
	}

	public static boolean contains(int[] digits, int number, int index) {
		for (int i = 0; i < digits.length; i++) {
			if (i !=index && number == digits[i]) {
				return false;
			}
		}
		return true;
	}
}
