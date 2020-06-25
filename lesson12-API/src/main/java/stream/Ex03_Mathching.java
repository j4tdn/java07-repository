package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03_Mathching {
//	 Example: Give a list of numbers: 1, 2, 1, 4, 5, 8, 10, 4, 12
//	 1
//	st: is there any element that is divisible by 10
//	 2
//	nd: find the first element that is divisible by 4
//	 3
//	nd: find the element that is divisible by 5 in the list
//	 4
//	th: does all elements less than 100
//	 5
//	th: does no elements greater than 0
	
	//optional; kiểu dữ liệu mới trng java 8 gểnic type 
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,1,4,5,8,10,4,12);
		boolean anyMath =  numbers.stream().anyMatch(num -> num % 10 == 0);
		// optional always != null
		// value Integer might be null;
		
		Optional<Integer> first = numbers.stream().filter(num -> num % 4 == 0).findFirst();
		Optional<Integer> element = numbers.stream().filter(num -> num % 5 == 0).findAny();
		boolean allMath = numbers.stream().allMatch(num -> num < 100);
		boolean allMath5th = numbers.stream().noneMatch((num -> num > 0 ));
		
		System.out.println(anyMath);
		System.out.println(first);
		System.out.println(element);
		System.out.println(allMath);
		System.out.println(allMath5th);
		
	}
	
}
