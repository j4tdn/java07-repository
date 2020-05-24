package collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Ex04 {
	public static void main(String[] args) {
		List<Integer> digits = random(5);

		Collections.sort(digits, (i1, i2) -> i1.compareTo(i2));

		Collections.reverse(digits);
		digits.forEach(digit -> System.out.print(digit + " "));
		//remove by index
		//digits.remove(2);
		//System.out.println();
		//digits.forEach(digit -> System.out.print(digit + " "));
		//remove by element;
		//digits.remove(new Integer(2));
		//System.out.println();
		//digits.forEach(digit -> System.out.print(digit + " "));
		//remove the odd numbers
//		digits.removeIf(new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer t) {
//				return t%2==0;
//				
//			}
//			
//		});
		
		digits.removeIf(digit ->digit %2==0);
			
		digits.set(0, 99);
//		Predicate<Integer> filter = new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer t) {
//				// TODO Auto-generated method stub
//				return t%2==0;
//			}
//			
//		};
		
		System.out.println();
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
