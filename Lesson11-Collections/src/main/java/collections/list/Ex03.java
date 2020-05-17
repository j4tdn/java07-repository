package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Random rd = new Random();

		do {
			int rand = rd.nextInt(10) + 1;
			if (contains(rand, numbers)) {
				numbers.add(rand);
			}
		} while (numbers.size() < 5);

		numbers.forEach(number -> System.out.print(number + " "));
		System.out.println("\n=========");

		loop(numbers);
		System.out.println("\n=========");

		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.print(number + " ");
			}
		}
	}

	private static void loop(List<Integer> numbers) {
		// for index
		for (int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + " ");
		}
		System.out.println("\n=========");
		// for each
		for (int number : numbers) {
			System.out.print(number + " ");
		}
		System.out.println("\n=========");
		// iterator
		Iterator<Integer> iterator = numbers.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

	private static boolean contains(int rand, List<Integer> numbers) {
		for (int number : numbers) {
			if (rand == number) {
				return false;
			}
		}
		return true;
	}
}