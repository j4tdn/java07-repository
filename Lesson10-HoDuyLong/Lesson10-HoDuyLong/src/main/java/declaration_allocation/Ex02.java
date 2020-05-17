package declaration_allocation;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[] numbers = { 11, 33, 77, 66, 22 };

		int[] evenNumbers = printEvenNumbers(numbers);
		for (int evenNumber : evenNumbers) {
			System.out.println(evenNumber);
		}
		System.out.println("===========================");
		System.out.println(sumOfOddNumbers(numbers));
		System.out.println("===========================");
		
		numbers[0] = 199;
		for (int number : numbers) {
			System.out.println(number);
		}
		System.out.println("===========================");
		System.out.println(maxElement(numbers));
		System.out.println("===========================");
		System.out.println(secondMaxElement(numbers));
		System.out.println("===========================");
		sort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);
		System.out.println("===========================");
		int[] result = insert(numbers, 2, 55);
		Arrays.stream(result).forEach(System.out::println);
	}

	private static int[] printEvenNumbers(int[] numbers) {
		int length = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				length++;
			}
		}
		int[] evenNumbers = new int[length];
		int index = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				evenNumbers[index++] = number;
			}
		}
		return evenNumbers;
	}

	private static int sumOfOddNumbers(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number % 2 == 1) {
				sum += number;
			}
		}
		return sum;
	}
	
	private static int maxElement(int[] numbers) {
		int max = numbers[0];
		for (int number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		return max;
	}
	
	private static int secondMaxElement(int[] numbers) {
		int max = numbers[0] > numbers[1] ? numbers[0] : numbers[1];
		int secondMax = numbers[0] > numbers[1] ? numbers[1] : numbers[0];
		
		for (int number : numbers) {
			if (number > max) {
				secondMax = max;
				max = number;
			} else if (number != max && number > secondMax) {
				secondMax = number;
			}
		}
		return secondMax;
	}
	
	// bubble sort
	private static void sort(int[] numbers) {
		for (int out = numbers.length - 1 ; out > 0 ; out--) {
			for (int in = 0 ; in <= out ; in++) {
				if (numbers[in] > numbers[out]) {
					int temp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = temp;
				}
			}
		}
	}
	
	private static int[] insert(int[] numbers, int k, int value) {
		int[] result = new int[numbers.length + 1];
		for (int i = 0 ; i < k ; i++) {
			result[i] = numbers[i];
		}
		result[k] = value;
		for (int i = k + 1 ; i < result.length ; i++) {
			result[i] = numbers[i - 1];
		}
		return result;
	}
}
