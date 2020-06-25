package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03Matching {

	public static void main(String[] args) {
//		Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
//		1st: is there any element that is divisible by 10
//		2nd: find the first element that is divisible by 4
//		3nd: find the element that is divisible by 5 in the list
//		4th: does all elements less than 100
//		5th: does no elements greater than 0

		List<Integer> numbers = Arrays.asList(1, 2, 1, 4, 5, 8, 10, 4, 12);

		boolean anyMap = numbers.stream().anyMatch(num -> (num % 10 == 0));

		// optional always != null
		// value Integer might be null
		Integer first = numbers.stream().filter(num -> num % 4 == 0).findFirst().get();

		Integer element = numbers.stream().filter(n -> n % 5 == 0).findAny().get();

		boolean allMatch = numbers.stream().allMatch(num -> num < 100);

		boolean noneMatch = numbers.stream().noneMatch(n -> n > 0);

		System.out.println("any map: " + anyMap);

		System.out.println("find any: " + element);

		System.out.println("allMatch: " + allMatch);

		System.out.println("noneMatch: " + noneMatch);

		System.out.println("find first: " + first);

	}

}
