package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03Matching {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1 , 4, 5, 8, 10, 4, 12);
		
		boolean check1st = numbers.stream().anyMatch(num -> num % 10 == 0);
		Integer first = numbers.stream().filter(num -> num % 4 == 0).findFirst().get();
		//optional always != null
		//value of optional might be null
		Integer element = numbers.stream().filter(num -> num % 5 == 0).findAny().get(); 
		boolean allMatch = numbers.stream().allMatch(num -> num < 100);
		boolean allMatch5th = numbers.stream().noneMatch(num -> num > 0);
		
		System.out.println(check1st);
		System.out.println(first);
		System.out.println(element);
		System.out.println(allMatch);
		System.out.println(allMatch5th);
	}
}
