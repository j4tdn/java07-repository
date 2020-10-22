package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex03Matching {
	public static void main(String[] args) {
		/**
		 * Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
				1st: is there any element that is divisible by 10
				2nd: find the first element that is divisible by 4
				3nd: find the element that is divisible by 5 in the list
				4th: does all elements less than 100
				5th: does no elements greater than 0
		 */
		
		List<Integer> numbers = Arrays.asList(6,1,2,1,4,5,8,10,4,12);
		// bug: findAny
		System.out.println("any: " + numbers.stream().findAny().get());
		
		boolean anyMatch = numbers.stream().anyMatch(num -> num % 10 == 0);
		Integer first = numbers.stream().filter(num -> num % 4 == 0).findFirst().get();
		Integer element = numbers.stream().filter(num -> num % 5 == 0).findAny().get();
		boolean allMatch = numbers.stream().allMatch(num -> num < 100);
		boolean allMatch5th = numbers.stream().noneMatch(num -> num > 0);
		
		System.out.println(anyMatch + ", " 
					  	 + first    + ", " 
					 	 + element  + ", " 
						 + allMatch + ", " 
						 + allMatch5th);
	}
}
