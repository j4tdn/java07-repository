package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits = random(5);

		Collections.sort(digits, (i1, i2) -> i2.compareTo(i1));
		digits.forEach(number -> System.out.print(number + " "));
		System.out.println("\n=========");
		Collections.reverse(digits);
		digits.forEach(number -> System.out.print(number + " "));
	}

	private static List<Integer> random(int index) {
		List<Integer> numbers = new ArrayList<>();
		Random rd = new Random();
		do {
			int rand = rd.nextInt(10) + 1;
			if (contains(rand, numbers)) {
				numbers.add(rand);
			}
		} while (numbers.size() < index);
		return numbers;
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