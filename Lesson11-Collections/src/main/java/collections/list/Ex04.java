package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits = random(5);

		Collections.sort(digits, (i1, i2) -> i2.compareTo(i1));
		Collections.reverse(digits);

		digits.forEach(digit -> System.out.print(digit + " "));

		// remove by index
		// digits.remove(2);

		// remove by element
		// digits.remove(new Integer(2));

		// remove the odd numbers
		digits.removeIf(digit -> digit % 2 == 0);
		digits.set(0, 99);

		System.out.println("\n====================");
		digits.forEach(digit -> System.out.print(digit + " "));
	}

	private static List<Integer> random(int n) {
		List<Integer> digits = new ArrayList<>();
		Random rd = new Random();
		int i = 0;
		while (i < n) {
			int rand = rd.nextInt(5) + 1;
			if (!digits.contains(rand)) {
				digits.add(rand);
				i++;
			}
		}
		return digits;
	}
}
