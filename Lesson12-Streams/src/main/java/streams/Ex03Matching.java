package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03Matching {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 4, 5, 8, 10, 4, 12);
		System.out.println("any :" + numbers.stream().findAny().get());
		boolean anyMatch = numbers.stream().anyMatch(num -> num % 10 == 0);
		System.out.println(anyMatch);
		// optional alays !=null
		// value Interger might be null
		Integer first = numbers.stream().filter(num -> num % 4 == 0).findFirst().get();
		System.out.println(first);
		Integer elenment = numbers.stream().filter(num -> num % 5 == 0).findAny().get();
		System.out.println(elenment);
		boolean allMatch = numbers.stream().allMatch(num -> num < 100);
		System.out.println(allMatch);
		
		boolean noneMatch = numbers.stream().noneMatch(num -> num > 0);
		System.out.println(noneMatch);
	}

}
