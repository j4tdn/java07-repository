package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bt3 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", "4", "8", "Special", "a", "c", "b", "xx" };
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
		System.out.println("");

		int[] numbers = getNumbers(strings);
		Arrays.sort(numbers);
		Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));
		System.out.println();

		String[] results = getStrings(strings, strings.length - numbers.length - 1);
		Arrays.sort(results, (o1, o2) -> o1.compareTo(o2));
		Arrays.stream(results).forEach(result -> System.out.print(result + " "));
		System.out.println();

		String[] sortStrings = sortToArray(strings, numbers, results);
		Arrays.stream(sortStrings).forEach(sortString -> System.out.print(sortString + " "));
		System.out.println();

		reversed(sortStrings);
		Arrays.stream(sortStrings).forEach(sortString -> System.out.print(sortString + " "));

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static String[] sortToArray(String[] strings, int[] numbers, String[] results) {
		String[] stringArrays = new String[strings.length];
		stringArrays[0] = "Special";
		Arrays.sort(numbers);
		Arrays.sort(results, (o1, o2) -> o1.compareTo(o2));
		for (int i = 1; i <= numbers.length; i++) {
			stringArrays[i] = String.valueOf(numbers[i - 1]);
		}
		for (int i = numbers.length + 1; i < strings.length; i++) {
			stringArrays[i] = results[i - numbers.length - 1];
		}
		return stringArrays;
	}

	private static int[] getNumbers(String[] strings) {
		List numberList = new ArrayList();
		for (String string : strings) {
			try {
				numberList.add(Integer.parseInt(string.toString()));
				// ep kieu roi add vao list
			} catch (RuntimeException e) {
				// neu ko ep duoc thi continue
				continue;
			}
		}
		int[] numbers = convertToArray(numberList);// chuyen list thanh mang
		return numbers;
	}

	private static String[] getStrings(String[] in, int length) {
		String[] strings = new String[length];
		int cout = 0;
		for (String i : in) {
			try {
				Integer.parseInt(i.toString());
			} catch (RuntimeException e) {
				if (i.compareTo("Special") != 0) {
					strings[cout++] = i;
				}
			}

		}
		return strings;
	}

	@SuppressWarnings("rawtypes")
	public static int[] convertToArray(List list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = Integer.parseInt(list.get(i).toString());
		}
		return array;
	}

	private static void reversed(String[] strings) {
		for (int i = 0; i < strings.length / 2; i++) {
			String tmp = strings[i];
			strings[i] = strings[strings.length - i - 1];
			strings[strings.length - i - 1] = tmp;
		}

	}

}
