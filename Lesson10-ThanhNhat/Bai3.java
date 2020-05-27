package BTDATE01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bai3 {
	public static void main(String[] args) {
		String[] input = { "4", "a", "xx", "10", "b", "Special", "-2", "c", "-6", "8" };
		System.out.print("Input String:  ");
		Arrays.stream(input).forEach(string -> System.out.print(string + "  "));

		int[] numbers = getNumbers(input);
		String[] strings = getStrings(input, input.length - numbers.length - 1);
		
		System.out.println();
		
		System.out.print("Ascending Sort:  ");
		String[] sortStrings = sort(input, numbers, strings);
		Arrays.stream(sortStrings).forEach(string -> System.out.print(string + "  "));

		System.out.println();

		System.out.print("Descending Sort:  ");
		Collections.reverse(Arrays.asList(sortStrings));
		Arrays.stream(sortStrings).forEach(string -> System.out.print(string + "  "));
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private static int[] getNumbers(String[] input) {
		List numbersList = new ArrayList();
		for (int i = 0; i < input.length; i++) {
			try {
				numbersList.add(Integer.parseInt(input[i].toString()));
			} catch (RuntimeException e) {
				continue;
			}
		}
		int[] numbersArray = Bai2.convertToArray(numbersList);
		return numbersArray;
	}

	private static String[] getStrings(String[] input, int length) {
		String[] strings = new String[length];
		int j = 0;
		for (int i = 0; i < input.length; i++) {
			try {
				Integer.parseInt(input[i].toString());
			} catch (RuntimeException e) {
				if (input[i].compareTo("Special") != 0) {
					strings[j++] = input[i];
				}
			}
		}
		return strings;
	}

	private static String[] sort(String[] input, int[] numbers, String[] strings) {
		String[] result = new String[input.length];
		result[0] = "Special";
		Arrays.sort(numbers);
		Arrays.sort(strings, (o1, o2) -> o1.compareTo(o2));
		for (int i = 1; i <= numbers.length; i++) {
			result[i] = String.valueOf(numbers[i - 1]);
		}
		for (int i = numbers.length + 1; i < input.length; i++) {
			result[i] = strings[i - numbers.length - 1];
		}
		return result;
	}
}
