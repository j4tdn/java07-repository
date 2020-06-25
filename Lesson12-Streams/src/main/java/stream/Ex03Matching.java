package stream;

import java.util.Arrays;
import java.util.List;

public class Ex03Matching {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 4, 5, 8, 10, 4, 12);
		boolean anyMatch = numbers.stream().anyMatch(number -> number % 10 == 0);
		System.out.println("- " + anyMatch);
//		optional always != null
//		value Integer might be null
		Integer first = numbers.stream().filter(number -> number % 4 == 0).findFirst().get();
		System.out.println("- " + first);
		Integer element = numbers.stream().filter(number -> number % 5 == 0).findAny().get();
		System.out.println("- " + element);
		boolean allMatch = numbers.stream().allMatch(number -> number < 100);
		System.out.println("- " + allMatch);
		boolean noneMatch = numbers.stream().noneMatch(number -> number > 0);
		System.out.println("- " + noneMatch);
	}
}