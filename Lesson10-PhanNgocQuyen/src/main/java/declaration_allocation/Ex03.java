package declaration_allocation;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		// 1 6 3 4 6 3 6 7
		// 1 3 3 4 6 6 6 7
		// distinct: 1 6 3 4 7
		// getUniqueNumbers: 1 4 7
		int[] numbers = {1, 6, 3, 0, 4 , 6, 3, 7};
		// numbers = distinct(numbers);
		// Arrays.stream(numbers).forEach(num -> System.out.print(num + "  "));
		// Arrays.stream(numbers).distinct().forEach(num -> System.out.print(num + "  "));
		
		numbers = getUniqueNumbers(numbers);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + "  "));
	}
	
	private static int[] getUniqueNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		// 2st way
		/*
		int index = 0;
		for (int number: numbers) {
			if (isUnique(numbers, number)) {
				result[index++] = number;
			}
		}
		*/
		// 2nd way
		/*
		int index = 0;
 		for (int out = 0; out < numbers.length; out++) {
 			int count = 1;
			for (int in = 0 ; in < numbers.length; in++) {
				if (out != in && numbers[out] == numbers[in]) {
					count++;
					break;
				}
			}
			if (count == 1) {
				result[index++] = numbers[out];
			}
		}
		*/
		// 3rd way
		
		int index = 0;
		boolean[] flags = new boolean[numbers.length];
		Arrays.fill(flags, true);
		// 
		for(int out = 0; out < numbers.length; out++) {
			if (flags[out]) {
				for (int in = out + 1; in < numbers.length; in++) {
					if (numbers[out] == numbers[in]) {
						flags[in] = flags[out] = false;
					}
				}
				
				if (flags[out]) {
					result[index++] = numbers[out];
				}
				
			}
			
			
		}
		
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isUnique(int[] numbers, int input) {
		int count = 0;
		for (int number: numbers) {
			if (number == input) {
				count++;
				if (count == 2) {
					return false;
				}
			}
		}
		return true;
	}

	private static int[] distinct(int[] numbers) {
		int[] result = new int[numbers.length];
		int i = 0;
		for (int number : numbers) {
			if (!contains(result, number, i)) {
				result[i++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, i) ;
	}

	private static boolean contains(int[] result, int number, int validNumberIndex) {
		for (int i = 0; i < validNumberIndex; i++) {
			if (result[i] == number) {
				return true;
			}
		}
		
		return false;
	}

}
