package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import sorting.SortType;

public class Ex03 {
	public static void main(String[] args) {
		String[] inputStrings = { "-2", "-6", "10", "4", "8", "Special", "a", "c", "b", "xx", "Special" };
		sort(inputStrings, SortType.ASC);
	}

	private static void sort(String[] inputStrings, SortType sort) {
		System.out.println("Givens Arrays: ");
		Arrays.stream(inputStrings).forEach(string -> System.out.print(string + " "));
		List<String> results = new ArrayList<>();
		results.addAll(sortSpecial(inputStrings));
		results.addAll(sortNumbers(inputStrings, sort));
		results.addAll(sortStrings(inputStrings, sort));
		if(sort == SortType.ASC) {
			System.out.println("\nSorted ASC Arrays: ");
			results.forEach(result -> System.out.print(result + " "));
		}
		else {
			Collections.reverse(results);
			System.out.println("\nSorted DESC Arrays: ");
			results.forEach(result -> System.out.print(result + " "));
		}
		
	}

	private static List<String> sortStrings(String[] inputStrings, SortType sort) {
		List<String> strings = new ArrayList<>();
		for (String string : inputStrings) {
			if(!isNumberic(string) && "Special".equals(string) == false) {
				strings.add(string);
			}
		}
		return strings;
	}

	private static List<String> sortSpecial(String[] inputStrings) {
		List<String> specials = new ArrayList<>();
		for (String string : inputStrings) {
			if ("Special".equals(string)) {
				specials.add(string);
			}
		}
		return specials;
	}

	private static List<String> sortNumbers(String[] inputStrings, SortType sort) {
		List<Integer> numbers = new ArrayList<>();
		List<String> results = new ArrayList<>();
		for (String string : inputStrings) {
			if (isNumberic(string)) {
				numbers.add(Integer.parseInt(string));
			}
		}
		Collections.sort(numbers);
		for (Integer number : numbers) {
			results.add(number.toString());
		}
		return results;
	}

	private static boolean isNumberic(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
