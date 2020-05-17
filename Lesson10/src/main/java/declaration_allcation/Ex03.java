package declaration_allcation;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 9, 3, 3, 8 };
		// distinct:1,3,5,0,7
		// int[] result = distinct(numbers);
		// Arrays.stream(result).forEach(num -> System.out.print(num + " "));
		// for (int number : result) {
		// System.out.println(number);
		// }
		// Arrays.stream(numbers).distinct().forEach(num->System.out.print(num+" "));
		int[] result2 = getUniqueNumbers3(numbers);
		Arrays.stream(result2).forEach(num -> System.out.print(num + " "));

	}

	private static int[] getUniqueNumbers2(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
		for (int number : numbers) {
			if (isUnique(numbers, number)) {
				result[index++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, index);

	}

	private static boolean isUnique(int[] numbers, int input) {
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

	private static int[] distinct(int[] numbers) {
		int[] result = new int[numbers.length];
		int i = 0;

		for (int number : numbers) {
			if (!contains(result, number, i)) {
				result[i++] = number;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}

	private static boolean contains(int[] result, int number, int validNumberIndex) {
		for (int i = 0; i < validNumberIndex; i++) {
			if (result[i] == number) {
				return true;
			}
		}
		return false;

	}

	private static int[] getUniqueNumbers(int[] numbers) {

		int[] result = new int[numbers.length];
		int count = 1;
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {
			// boolean b = true;
			for (int j = 0; j < numbers.length; j++) {
				if (i != j && numbers[i] == numbers[j]) {
					// b = false;
					count++;
					break;
				}
			}
			// if (b == true) { result[count++] = numbers[i]; }
			if (count == 1) {
				result[index++] = numbers[i];
			}
		}
		System.out.println(count);
		return Arrays.copyOfRange(result, 0, count);
	}

	

	private static int[] getUniqueNumbers3(int[] numbers) {
		int[] result = new int[numbers.length];
		boolean[] flags = new boolean[numbers.length];
		int index=0;
		
		Arrays.fill(flags, true);
		for (int i = 0; i < numbers.length; i++) {
			if(flags[i]) {
				for (int j = i+1; j < numbers.length; j++) {
					if(numbers[i]==numbers[j]) {
						flags[i]=false;
						flags[j]=false;
					}
				}
			}
			if(flags[i]==true) {
				result[index++] = numbers[i];
			}
		}
		
		return Arrays.copyOfRange(result, 0, index);

	}
}