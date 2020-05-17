package view;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 11, 199, 77, 66, 22 };

		totalOfOddNumbers(numbers);
		System.out.println("-------------");

		numbers[0] = changeTheFirstElement(numbers[0]);
		Arrays.stream(numbers).forEach(System.out::println);
		System.out.println("-------------");

		System.out.println("Ptử lớn thứ 1: " + max(numbers));
		System.out.println("-------------");

		System.out.println("Ptử lớn thứ 2: " + max2(numbers));
		System.out.println("-------------");

		sort(numbers);
		Arrays.stream(numbers).forEach(System.out::println);
		System.out.println("-------------");

		int[] arr = addInt(numbers, 10, 4);
		Arrays.stream(arr).forEach(System.out::println);
		System.out.println("-------------");
	}

	private static void totalOfOddNumbers(int[] numbers) {
		int s = 0;
		System.out.print("Các ptử chẵn trong mảng: ");
		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.print(number + " ");
				s += number;
			}
		}
		System.out.println("\nTổng các ptử chẵn trong mảng: " + s);
	}

	private static int changeTheFirstElement(int temp) {
		temp = 199;
		return temp;
	}

	private static int max(int[] numbers) {
		int count = 0;
		int max = numbers[count];
		int max2 = numbers[count];

		for (int number : numbers) {
			if (max2 < number && max != number) {
				max2 = number;
				if (max <= max2) {
					int temp = max2;
					max2 = max;
					max = temp;
				}
			}
		}
		// System.out.println(max);
		if (max2 < max) {
			System.out.println(max2);
		}
		return max;
	}

	private static int max2(int[] numbers) {
		int max = numbers[0] > numbers[1] ? numbers[0] : numbers[1];
		int max2 = numbers[0] < numbers[1] ? numbers[0] : numbers[1];

		for (int number : numbers) {
			if (max < number) {
				max2 = max;
				max = number;
			} else if (number != max && number > max2) {
				max2 = number;
			}
		}
		return max2;
	}

	private static void sort(int[] numbers) {
		for (int out = numbers.length - 1; out > 0; out--) {
			for (int in = 0; in <= out; in++) {
				if (numbers[in] > numbers[out]) {
					swap(numbers, in, out);
				}
			}
		}
	}

	private static void swap(int[] numbers, int in, int out) {
		int temp = in;
		in = out;
		out = temp;
	}

	private static int[] addInt(int[] number, int value, int k) {
		int[] addNumbers = new int[number.length + 1];
		for (int i = 0; i < addNumbers.length; i++) {
			if (i < k) {
				addNumbers[i] = number[i];
			} else if (i == k) {
				addNumbers[i] = value;
			} else {
				addNumbers[i] = number[i - 1];
			}
		}
		return addNumbers;
	}
}
