package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex1_1 {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		createArrays(numbers, 10);
		showArray(numbers);
		lcm(numbers);
		secondMax(numbers);
		sumElements(numbers);
	}

	private static void showArray(List<Integer> numbers) {
		System.out.print("Elements of Array: ");
		numbers.forEach(number -> System.out.print(number + " "));		
	}

	private static void sumElements(List<Integer> numbers) {
		System.out.println(
				"The sum of the first and last element: " + (numbers.get(0) + numbers.get(numbers.size() - 1)));
	}

	private static void secondMax(List<Integer> numbers) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (Integer number : numbers) {
			if (number > max) {
				secondMax = max;
				max = number;
			}else {
				if(number > secondMax && number != max) {
					secondMax = number;
				}
			}
		}
		System.out.println("Second Max in Arrays: " + secondMax);
	}

	private static void lcm(List<Integer> numbers) {
		long lcm = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++) {
			lcm = lcmOfTwoNumber(lcm, numbers.get(i));
		}
		System.out.println("\nLCM Of Elements in Arrays: " + lcm);
	}

	private static long lcmOfTwoNumber(long a, Integer b) {
		long lcm = 0;
		long maxValue = a * b;
		long step = Math.max(a, b);
		for (long i = step; i <= maxValue; i += step) {
			if (i % a == 0 && i % b == 0) {
				lcm = i;
				break;
			}
		}
		return lcm;
	}

	private static void createArrays(List<Integer> numbers, int n) {
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			numbers.add(rand.nextInt(91) + 10);
		}
	}
}
