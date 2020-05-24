package collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Ex04 {
	
	public static void main(String[] args) {
		List<Integer> digits = random(5);
		Collections.sort(digits, (i1, i2) -> i1.compareTo(i2));
		Collections.reverse(digits);
		digits.forEach(digit -> System.out.print(digit + " "));
		
//		remove by element		
//		digits.remove(new Integer(2));
		
//		remove the odd numbers
//		digits.removeIf(new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer t) {
//				return t % 2 == 0;
//			}
//		});
		digits.removeIf(number -> (number % 2 == 0));
		digits.set(0, 100);
		System.out.println("\n===============");
		digits.forEach(digit -> System.out.print(digit + " "));

	}

	private static List<Integer> random(int n) {
		List<Integer> digits = new ArrayList();
		int i = 0;
		Random rd = new Random();
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
