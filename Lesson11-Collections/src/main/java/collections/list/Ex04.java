package collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits = random(5);

		Collections.sort(digits, (i1, i2) -> i2.compareTo(i1));
		Collections.reverse(digits);

		digits.forEach(digit -> System.out.print(digit + " "));

		// digits.remove(new Integer(2));
		
		//lamda exp
		digits.removeIf(t -> t % 2 == 0);
		System.out.println();
		digits.forEach(digit -> System.out.print(digit + " "));
		
		/***
		digits.removeIf(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		});
		*/

		/***
		 * Predicate<Integer> filter = new Predicate<Integer>() {
		 * 
		 * @Override public boolean test(Integer t) { return t % 2 == 0; } };
		 * 
		 *           Objects.requireNonNull(filter); final Iterator<Integer> each =
		 *           digits.iterator(); while (each.hasNext()) { if
		 *           (filter.test(each.next())) { each.remove(); } }
		 */
	}

	private static List<Integer> random(int n) {
		List<Integer> digits = new ArrayList<>();
		Random rand = new Random();
		int count = 0;
		while (count < 5) {
			int number = rand.nextInt(10) + 1;
			if (!digits.contains(number)) {
				digits.add(number);
				count++;
			}
		}
		return digits;
	}
}
