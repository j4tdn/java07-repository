package collections.list;

import java.awt.Container;
import java.lang.reflect.Array;
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
			int rand = rd.nextInt(5) + 1;
			if (!Contain(numbers, rand)) {
				numbers[i] = rand;
				i++;

			}

		}
		System.out.println("===============");
		Arrays.stream(numbers).forEach(num -> System.out.println(num + " "));

		System.out.println("================================================");
		List<Integer> digits = new ArrayList<>();
		System.out.println("digits size :" + digits.size());
		int size = 5;
		int cout = 0;
		while (cout < size) {
			int rand = rd.nextInt(5) + 1;
			if (!digits.contains(rand)) {
				digits.add(rand);
				cout++;

			}

		}
		System.out.println("digits size :" + digits.size());
		// digits.forEach(digit -> System.out.print(digit + " "));
		loop(digits);
		

	}

	private static void loop(List<Integer> digits) {

		// for index
		System.out.println("============index===========");
		for (int i = 0; i < digits.size(); i++) {
			System.out.println(digits.get(i) + "");

		}
		// for each
		System.out.println("===========each===========");
		for (Integer digit : digits) {
			System.out.println(digit + " ");
		}
		// iterator,iterable
		System.out.println("=============iterator=============");
		Iterator<Integer> iterator = digits.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}

	}

	private static boolean Contain(int[] numbers, int rand) {
		for (int number : numbers) {
			if (number == rand) {
				return true;
			}
		}
		return false;
	}

}
