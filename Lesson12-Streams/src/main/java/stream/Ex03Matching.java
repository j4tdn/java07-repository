package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex03Matching {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 8, 10,4, 12);
		boolean anyMatch =  numbers.stream().anyMatch(num -> num % 10 == 0);
		//optional always !=null;
		//value Integer might be null;
		 
		Integer first = numbers.stream().filter(num->num%4==0).findFirst().get();
		Integer element = numbers.stream().filter(num->num%5==0).findAny().get();
		boolean allMatch = numbers.stream().allMatch(num->num<100);
		boolean allmatch5 = numbers.stream().noneMatch(num->num>0);
		System.out.println(anyMatch+", "+first+", "+element+", "+allMatch+", "+allmatch5);
	}
}
