package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] numbers = new int[5];

		for (int i = 0; i < numbers.length;) {
			int rand = rd.nextInt(10) + 1;
			if (!contains(numbers, rand)) {
				numbers[i] = rand;
				i++;
			}
		}

		System.out.println("===============");
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));

		System.out.println("\n===============");

		List<Integer> digits = new ArrayList<>();

		int size = 5;
		int count = 0;

		while (count < size) {
			int rand = rd.nextInt(10) + 1;
			if (!digits.contains(rand)) {
				digits.add(rand);
				count++;
			}
		}
		System.out.println("digits size : " + digits.size());

		digits.forEach(digit -> System.out.print(digit + " "));

		System.out.println("\n=====================");
		loop(digits);
	}

	private static void loop(List<Integer> digits) {
		System.out.println("========Index==========");
		// for index
		for (int i = 0; i < digits.size(); i++) {
			System.out.print(digits.get(i) + " ");
		}

		System.out.println("\n=========Each=========");
		// for each
		for (Integer digit : digits) {
			System.out.print(digit + " ");
		}

		System.out.println("\n======Iterator========");
		// inerator,iterable

		Iterator<Integer> iterator = digits.iterator();
		// neu con be hon length
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

	private static boolean contains(int[] numbers, int rand) {
		for (int number : numbers) {
			if (number == rand) {
				return true;
			}
		}
		return false;
	}

}
