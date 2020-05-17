package declaration_allcation;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[] numbers = { 111, 32, 55, 66, 66, 11 };
		
		printEvenNumbers(numbers);
		System.out.println("total of odd number " + totalOfOddNumber(numbers));
		
		secondMax(numbers);
		
		sort(numbers);
		
		// in theo ham co san
		//Arrays.stream(numbers).forEach(System.out::println);
		// hoac
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));

	}
	
	private static int[] insert(int[] numbers, int value, int index) {
		int[] results = new int[numbers.length + 1];

		for(int i = 0; i < index; i++) {
			results[i] = numbers[i];
		}
		
		results[index] = value;
		
		for(int i = index + 1; i < results.length; i++) {
			results[i] = numbers[i-1];
		}
		

//		for(int i = 0; i < results.length; i++) {
//			if(i < index) {
//				results[i] = numbers[i];
//			}else if (i == index) {
//				results[i] = value;
//			}else {
//				results[i] = numbers[i - 1];
//			}
//		}
		
		
		return results;
	}
	
	private static int[] insertV2(int[] numbers, int value, int index) {
		int[] results = new int[numbers.length + 1];

		for(int i = 0; i < numbers.length; i++) {
			results[i] = numbers[i];
		}
		
		for(int i = results.length - 1; i > index; i--) {
			results[i] = numbers[i-1];
		}
		results[index] = value;
		return results;
	}
	
	//bubble sort
	private static void sort(int[] numbers) {
		for(int out = numbers.length - 1; out > 0; out--) {
			for(int in = 0; in < out; in++) {
				if(numbers[in] > numbers[out]) {
					int tmp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = tmp;
				}
			}
		}
	}
	
	private static int max(int[] numbers) {
		int max = numbers[0];
		
		for(int number :numbers) {
			if(number > max) {
				max = number;
			}
		}
		return max;
	}
	
	private static int secondMax(int[] numbers) {
		int max = numbers[0] > numbers[1] ? numbers[0] : numbers[1];
		int secondMax = numbers[0] < numbers[1] ? numbers[0] : numbers[1];
		
		for(int number :numbers) {
			if(number > max) {
				secondMax = max; 
				max = number;
			} else if (number != max && number > secondMax) {
				secondMax = number;
			}
		}
		return secondMax;
	}

	private static void printEvenNumbers(int[] numbers) {
		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}
	}

	private static int totalOfOddNumber(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number % 2 != 0) {
				sum += number;
			}
		}
		return sum;
	}
	
	

}
