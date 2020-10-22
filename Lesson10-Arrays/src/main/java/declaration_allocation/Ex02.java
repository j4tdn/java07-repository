package declaration_allocation;

import java.util.Arrays;

public class Ex02 {
	/**
	 * 1. In ra các phần tử chẵn trong mảng 
	 * 2. Tính tổng các phần tử lẻ trong mảng
	 * 3. Thay đổi phần tử đầu tiên thành 199 
	 * 4. Tìm phần tử có giá trị lớn nhấttrong mảng 
	 * 5. Thêm 1 phần tử vào vị trí k trong mảng (0 <= k < n) 
	 * 6. Xóa 1 phần tử vào vị trí k trong mảng (0 <= k < n)
	 */
	public static void main(String[] args) {
		int[] numbers = { 11, 33, 77, 66, 22, 199, 200 };

		printEvenNumbers(numbers);
		System.out.println("Total of Odd Number: " + totalOfOddNumbers(numbers));

		numbers[0] = 199;

		System.out.println("Max: " + max(numbers));

		System.out.println("Second Max: " + secondMax(numbers));
		
		sort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + "  "));
		
		
		System.out.println();
		
		numbers = insert(numbers, 234, 3);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + "  "));

	}

	private static int max(int[] numbers) {
		int max = numbers[0];

		for (int number : numbers) {
			if (max < number) {
				max = number;
			}
		}

		return max;
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

	// 1. In ra các phần tử chẵn trong mảng
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

	// 2. In ra các phần tử chẵn trong mảng
	private static int totalOfOddNumbers(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			if (number % 2 != 0) {
				sum += number;
			}
		}
		return sum;
	}

	// bubble sort
	private static void sort(int[] numbers) {
		for (int out = numbers.length - 1; out > 0; out--) {
			for (int in = 0; in <= out; in++) {
				if (numbers[in] > numbers[out]) {
					int tmp = numbers[in];
					numbers[in] = numbers[out];
					numbers[out] = tmp;
				}
			}
		}
	}
	
	// 22  33  66  77  199  199  200
	// value = 234, index = 3
	private static int[] insert(int[] numbers, int value, int index) {
		int[] result = new int[numbers.length+1];
		/*
		for (int i = 0; i < index; i++) {
			result[i] = numbers[i];
		}
		result[index] = value;
		for (int i = index; i < numbers.length; i++) {
			result[i+1] = numbers[i];
		}
		*/
		for (int i = 0; i < result.length; i++) {
			if (i < index) {
				result[i] = numbers[i];
			} else if (i == index) {
				result[index] = value;
			} else {
				result[i] = numbers[i-1];
			}
		}
		return result;
	}
	
	private static int[] insertV2(int[] numbers, int value, int index) {
		int[] result = new int[numbers.length+1];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = numbers[i];
		}
		// shift right 1 unit
		for (int i = result.length - 1; i > index; i--) {
			result[i] = result[i - 1];
		}
		result[index] = value;

		return result;
	}

}
