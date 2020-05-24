package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits = random(5);

		Collections.sort(digits);
		digits.forEach(digit -> System.out.println(digit + " "));

		// remove index
		// digits.remove(2);

		// remove element
		// digits.remove(new Integer(5));

		// remove the old numbers
		digits.removeIf(digit -> digit % 2 == 0);

		digits.set(0, 99);
	}

	private static List<Integer> random(int n) {
		List<Integer> digits = new ArrayList<>();
		Random rd = new Random();
		int i = 0;
		while (i < n) {
			int rand = rd.nextInt(10) + 1;
			if (!digits.contains(rand)) {
				i++;
			}
		}
		return digits;
	}

}
