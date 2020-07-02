package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
		List<Integer> ones = getUniqueNumbers(numbers);
		List<Integer> more = getMore(numbers);
		
		ones.forEach(System.out::println);
		System.out.println("============");
		more.forEach(System.out::println);
	}
	
	private static List<Integer> getUniqueNumbers(List<Integer> numbers) {
		List<Integer> results = new ArrayList<>();
		int index = 0;

		for (Integer number : numbers) {
			if (isUnique(numbers, number)) {
				results.add(number);
			}
		}
		
		return results;
	}
	
	private static List<Integer> getMore(List<Integer> numbers) {
		List<Integer> results = new ArrayList<>();
		int index = 0;

		for (Integer number : numbers) {
			if (!isUnique(numbers, number)) {
				results.add(number);
			}
		}
		
		return results.stream().distinct().collect(Collectors.toList());
	}
	
	private static boolean isUnique(List<Integer> numbers, Integer input) {
		int count = 0;

		for (int item : numbers) {
			if (input == item) {
				count++;
			}
			if (count == 2) {
				return false;
			}
		}

		return true;
	}
}
