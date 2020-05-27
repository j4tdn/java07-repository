package excercise;

import java.util.Arrays;
import java.util.Random;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = createNumbers(10);

		Arrays.stream(digits).forEach(num -> System.out.print(num + "  "));

		System.out.println("\n======================");
		int[] result = removedDuplicateNumber(digits);
		Arrays.stream(result).forEach(num -> System.out.print(num + "  "));

		System.out.println("\nCompare 5 first element vs 5 last element: " + compareAvg(digits, 5));
		
		System.out.println("\n==========insertion sort============");
		insertionSort(digits);
		Arrays.stream(digits).forEach(num -> System.out.print(num + "  "));

	
		System.out.println("\n=====================================");
		System.out.println("Phan tu lon thu 3 trong mang: " + digits[digits.length - 3]);
	}

	private static int[] createNumbers(int length) {
		Random random = new Random();
		int[] digits = new int[length];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = random.nextInt(20) + 1;
		}

		return digits;
	}

	private static int[] removedDuplicateNumber(int[] digits) {
		int[] results = new int[digits.length];
		boolean[] flags = new boolean[digits.length];
		Arrays.fill(flags, true);

		for (int i = 0; i < digits.length; i++) {
			if (flags[i]) {
				for (int j = i + 1; j < digits.length; j++) {
					if (digits[i] == digits[j]) {
						flags[i] = false;
						flags[j] = false;
					}
				}
			}

		}

		int count = 0;
		int index = 0;
		for (boolean flag : flags) {
			if (flag) {
				results[count++] = digits[index];
			}
			index++;
		}
		return Arrays.copyOf(results, count);
	}

	private static boolean compareAvg(int[] digits, int index) {
		int firstTotal = 0;
		int count = 0;
		int secondTotal = 0;
		for (int digit : digits) {
			if (count < 5) {
				firstTotal += digit;
			} else {
				secondTotal += digit;
			}
			count++;
		}
		return firstTotal > secondTotal;
	}

	private static int[] insertionSort(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			for(int j = i + 1; j < digits.length; j++) {
				if(digits[j] < digits[i]) {
					int temp = digits[i];
					digits[i] = digits[j];
					digits[j] = temp;
					
				}
			}			
		}		
		return digits;
	}

}
