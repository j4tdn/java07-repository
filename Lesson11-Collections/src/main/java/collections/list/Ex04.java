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
		System.out.println("\n=========");

//		digits.remove(0);// remove phần tử thứ index
//		digits.forEach(number -> System.out.print(number + " "));
//		System.out.println("\n=========");
//		
//		digits.remove(new Integer(2));// remove phần tử có gtri bằng 2
//		digits.forEach(number -> System.out.print(number + " "));
//		System.out.println("\n=========");

//		digits.removeIf(new Predicate<Integer>() {
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 == 0;
//			}
//		});
		digits.removeIf((digit -> digit % 2 == 0));
		digits.forEach(number -> System.out.print(number + " "));
		System.out.println("\n=========");

		digits.set(0, 10);
		digits.forEach(number -> System.out.print(number + " "));
		System.out.println("\n=========");
	}

	private static List<Integer> random(int index) {
		List<Integer> numbers = new ArrayList<>();
		Random rd = new Random();
		do {
			int rand = rd.nextInt(5) + 1;
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