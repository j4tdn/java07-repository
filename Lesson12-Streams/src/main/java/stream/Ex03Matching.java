package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03Matching {
	public static void main(String[] args) {
		// Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
		// 1: is there any element that is divisible by 10
		// 2: find the first element that is divisible by 4
		// 3: find the element that is divisible by 5 in the list
		// 4: does all elements less than 100
		// 5: does no elements greater than 0

		List<Integer> numbers = Arrays.asList(1, 2, 1, 4, 5, 8, 10, 4, 12);
		boolean result = numbers.stream().anyMatch(num -> num % 10 == 0);
		System.out.println(result);
		Optional<Integer> optional = numbers.stream().filter(num -> num % 4 == 0).findFirst();
		// optional always != null
		// value Integer might be null
		System.out.println(optional.get());
		// optional.get();
		// optional.isPresent(); co hay ko, boolean
		// optional.orEsle(); neu ko thi gan mac dinh
		optional = numbers.stream().filter(num -> num % 5 == 0).findAny();
		System.out.println(optional.get());
		result = numbers.stream().allMatch(num -> num < 100);
		System.out.println(result);
		result = numbers.stream().noneMatch(num -> num > 0);
		System.out.println(result);
	}
}
