package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03Matching {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 1, 4 ,8, 10, 4, 12,5);

		/*
		 * 1 st: is there any element that is divisible by 10 2 nd: find the first
		 * element that is divisible by 4  3 nd: find the element that is divisible by
		 * 5 in the list  4 th: does all elements less than 100 5 th: does no elements
		 * greater than 0
		 */

		boolean c1 = numbers.stream().anyMatch(a -> a % 10 == 0);

		Optional<Integer> c2 = numbers.stream().filter(a -> a % 4 == 0).findFirst();

		Optional<Integer> c = numbers.stream().reduce((a,b)->a+b);

		// Optional alway !=null;
		// value integer might be null
		Optional<Integer> optional = numbers.stream().filter(a -> a % 5 == 0).findAny();

		boolean c4 = numbers.stream().allMatch(a -> a < 100);
		boolean c5 = numbers.stream().noneMatch(a -> a > 0);

		System.out.println(c);
		System.out.println(c1 + "\n" + c2.get() + "\n" + optional.get() + "\n" + c4 + "\n" + c5);

	}
}
