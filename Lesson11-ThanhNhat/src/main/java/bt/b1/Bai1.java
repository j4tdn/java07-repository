package bt.b1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bai1 {
	private static int size = 5;

	public static void main(String[] args) {
		Random rd = new Random();
		List<Integer> numbers = new ArrayList();

		for (int i = 0; i < size; i++) {
			numbers.add(rd.nextInt(91) + 10);
		}

		numbers.forEach(number -> System.out.println(number));

		System.out.println("Least Common Multiple: " + leastCommonMultipleOfList(numbers));

		System.out.println("Second Max: " + secondMax(numbers));

		System.out.println("The sum of the first and last element: " + sum(numbers));

	}

	private static int greatestCommonDivisor(int a, int b) {
		if (b == 0)
			return a;
		return greatestCommonDivisor(b, a % b);
	}

	private static int leastCommonMultiple(int a, int b) {
		return (a * b) / greatestCommonDivisor(a, b);
	}

	private static int leastCommonMultipleOfList(List<Integer> numbers) {
		int lcm = numbers.get(0);
		for (int i = 0; i < size - 1; i++) {
			lcm = leastCommonMultiple(lcm, numbers.get(i + 1));
		}
		return lcm;
	}

	private static Integer secondMax(List<Integer> numbers) {
		List<Integer> tmp = new ArrayList();
		tmp = numbers;
		tmp.sort((i1, i2) -> i1.compareTo(i2));
		for (int i = 0; i < size; i++) {
			if (!tmp.get(i).equals(tmp.get(i + 1))) {
				return tmp.get(i + 1);
			}
		}
		return null;
	}

	private static int sum(List<Integer> numbers) {
		return numbers.get(0) + numbers.get(size - 1);
	}
}
