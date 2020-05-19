package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		random(numbers);
		numbers.forEach(number -> System.out.print(number + " "));
		Collections.sort(numbers,(n1,n2)->n1.compareTo(n2));
		numbers.forEach(number -> System.out.print(number + " "));
		Collections.reverse(numbers);
		numbers.forEach(number -> System.out.print(number + " "));
	}

	private static void random(List<Integer> numbers) {
		Random rd = new Random();
		do {
			int number = rd.nextInt(10) + 1;
			if (contains(numbers, number)) {
				numbers.add(number);
			}

		} while (numbers.size() < 5);
	}

	private static boolean contains(List<Integer> numbers, int number) {

		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) == number) {
				return false;
			}
		}
		return true;

	}
}
