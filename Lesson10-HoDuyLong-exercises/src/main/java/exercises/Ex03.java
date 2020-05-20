package exercises;

import java.util.Arrays;

import common.Sort;

public class Ex03 {
	public static void main(String[] args) {
		String[] strings = { "-2", "-6", "10", "4", "8", "Special", "d", "a", "c", "16", "f", "Special", "b", "xx" };

		System.out.println("============ASCENDING=============");
		sortString(strings, Sort.ASCE);
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));

		System.out.println("\n==========DESCENDING===================");
		sortString(strings, Sort.DESC);
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
	}

	// bubble sort: "Special" first
	private static void sortString(String[] strings, Sort sort) {
		for (int out = 0; out < strings.length - 1; out++) {
			if (strings[out] == "Special") {
				continue;
			}
			for (int in = strings.length - 1; in >= out; in--) {
				if (strings[in] == "Special") {
					String temp = strings[in];
					strings[in] = strings[out];
					strings[out] = temp;
					break;
				}
				int comparision = strings[out].compareTo(strings[in]);
				if (comparision > 0) {
					String temp = strings[in];
					strings[in] = strings[out];
					strings[out] = temp;
				}
			}
		}
		int count = 0;
		int begin = 0;
		int end = 0;

		for (int i = 0; i < strings.length; i++) {
			if (isNumberic(strings[i])) {
				count++;
				end = i;
			}
		}
		begin = end - count + 1;

		sortNumberStrings(strings, begin, end);
		if (Sort.DESC.equals(sort)) {
			reverse(strings);
		}
	}

	private static void reverse(String[] strings) {
		for (int i = 0; i < strings.length / 2; i++) {
			String temp = strings[i];
			strings[i] = strings[strings.length - i - 1];
			strings[strings.length - i - 1] = temp;
		}
	}

	private static boolean isNumberic(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static void sortNumberStrings(String[] strings, int begin, int end) {
		for (int out = begin; out < end; out++) {
			for (int in = end; in >= out; in--) {
				if (Integer.parseInt(strings[out]) > Integer.parseInt(strings[in])) {
					String temp = strings[in];
					strings[in] = strings[out];
					strings[out] = temp;
				}
			}
		}
	}
}
