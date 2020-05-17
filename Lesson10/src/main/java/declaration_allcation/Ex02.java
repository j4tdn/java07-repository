package declaration_allcation;

import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 9, 7, 2, 4, 44, 77, 66 };
//		
//		printArray(printEvenNumbers(numbers));
//		System.out.println();
//		System.out.println(totalSumOddNumbers(numbers));
//		numbers[0] = 199;
//		printArray(numbers);
//		System.out.println();
//		System.out.println("Max: " + getMaxOfNumbers(numbers));
//		System.out.println("Second max: " + secondMax(numbers));
//		sortNumbers(numbers);
//		System.out.println();
//		Arrays.stream(numbers).forEach(System.out::println);
//		printArray(insert(numbers, 2, 1));
//		System.out.println();
//		printArray(insertV2(numbers, 3, 3));
//		System.out.println();
		printArray(delete(numbers, 2));
	}

	private static int[] printEvenNumbers(int[] numbers) {
		int length = 0;
		int index = 0;
		
		for (int number : numbers) {
			if (number % 2 == 0) {
				length++;
			}
		}
		
		int[] evenNumbers = new int[length];
		
		for (int number : numbers) {
			if (number % 2 == 0) {
				evenNumbers[index++] = number;
			}
		}
		return evenNumbers;
	}

	private static int totalSumOddNumbers(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number % 2 == 1) {
				sum += number;
			}
		}
		return sum;
	}
	
	private static int getMaxOfNumbers(int[] numbers) {
		int max = numbers[0];
		for (int number : numbers) {
			max = number > max ? number : max; 
		}
		return max;
	}
	
	//bubble sort
	private static void sortNumbers(int[] numbers) {
		for (int out = numbers.length - 1; out > 0; out--) {
			for (int in = 0; in <= out; in++) {
				if (numbers[in] > numbers[out]) {
					int temp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = temp;
				}
			}
		}
	}
	
	private static int secondMax(int[] numbers) {
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
	
	private static void printArray(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
	}
	
	private static int[] insert(int[] numbers,int value ,int k) {
		int[] results = new int[numbers.length + 1];
		for (int i = 0; i < results.length; i++) {
			if (i < k) {
				results[i] = numbers[i];
			}
			if (i == k) {
				results[i] = value;
			}
			if (i > k) {
				results[i] = numbers[i - 1];
			}
		}
		return results;
	}
	
	private static int[] delete(int[] numbers, int k) {
		int[] results = new int[numbers.length - 1];
		for (int i = 0; i < results.length; i++) {
			if (i < k) {
				results[i] = numbers[i];
			}
			if (i >= k) {
				results[i] = numbers[i + 1];
			}
		}
		return results;
	}

	private static int[] insertV2(int[] numbers,int value ,int k) {
		int[] results = new int[numbers.length - 1];
		for (int i = 0; i < numbers.length; i++) {
			results[i] = numbers[i];
		}
		
		for (int i = results.length - 1; i > k; i--) {
			results[i] = numbers[i - 1];
		}
		results[k] = value;
		return results;
	}
	
}
