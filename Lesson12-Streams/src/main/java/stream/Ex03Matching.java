package stream;

import java.util.Arrays;
import java.util.List;

public class Ex03Matching {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 8, 10, 4, 12);

		boolean anyMatch = numbers.stream().anyMatch(num -> num % 10 == 0);
		System.out.println(anyMatch);

		// optional always != null
		// value Integer can be null
		Integer first = numbers.stream().filter(num -> num % 4 == 0).findFirst().get();
		System.out.println(first);

		Integer element = numbers.stream().filter(num -> num % 5 == 0).findAny().get();
		System.out.println(element);

		boolean allMatch = numbers.stream().allMatch(num -> num < 100);
		System.out.println(allMatch);

		boolean allMatch5th = numbers.stream().noneMatch(num -> num > 0);
		System.out.println(allMatch5th);
	}
}
