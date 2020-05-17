package declaration;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		// 1 6 3 4 6 3 7
		// distinct:1 6 3 4 7
		// getUniqueNumbers:1 4 7
		int[] numbers = { 1, 6, 3, 4, 6, 3, 7 };
		Arrays.stream(numbers).distinct().forEach(num -> System.out.println(num + " "));

		Arrays.stream(getUniNumbers(numbers)).forEach(number -> System.out.print(number + " "));
	}

	private static int[] distinct(int[] numbers) {
		int[] result = new int[numbers.length];
		int i = 0;
		for (int number : numbers) {
			if (!check(number, result)) {
				result[i++] = number++;
			}
		}

		return Arrays.copyOfRange(result, 0, i);// copy vao mang
	}

	private static boolean check(int number, int[] result) {
		for (int item : result) {
			if (number == item) {
				return true;
			}
		}
		return false;
	}

	private static int[] getUniNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
//		for(int number:numbers) {
//			if(isUnique(number,numbers)) {
//				result[index] =number;
//			}
//		}
//		return result;
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
			}
			if (flags[out]) {
				result[index++] = numbers[out];
			}
		}
		return Arrays.copyOfRange(result, 0, index);

	}

	private static boolean isUnique(int number, int[] numbers) {

		return false;
	}

}
