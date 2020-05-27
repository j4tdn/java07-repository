package ex3;

import java.util.Arrays;

import common.Sort;

public class Ex01 {
	public static void main(String[] args) {
		String[] strings = { "2", "-3", "Special", "4", "aaa", "Special", "anh", "-8", "9", "baikhoqua", "java07" };
		strings = sortString(strings, Sort.ASC);
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
		strings = sortString(strings, Sort.DESC);
		System.out.println();
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
	}

	private static String[] sortString(String[] strings, Sort sort) {
		int indexSpecial = 0;
		int indexNumber = 0;
		int indexWord = 0;
		String[] result = new String[strings.length];
		String[] specials = new String[strings.length];
		String[] numbers = new String[strings.length];
		String[] words = new String[strings.length];
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("Special")) {
				specials[indexSpecial++] = strings[i];
			} else if (strings[i].matches("-\\d|\\d")) {
				numbers[indexNumber++] = strings[i];
			} else {
				words[indexWord++] = strings[i];
			}
		}

		numbers = Arrays.copyOfRange(numbers, 0, indexNumber);
		words = Arrays.copyOfRange(words, 0, indexWord);

		for (int out = 0; out < numbers.length - 1; out++) {
			for (int in = out + 1; in < numbers.length; in++) {
				if (Integer.parseInt(numbers[out]) > Integer.parseInt(numbers[in])) {
					String temp = numbers[out];
					numbers[out] = numbers[in];
					numbers[in] = temp;
				}
			}
		}

		for (int out = 0; out < words.length - 1; out++) {
			for (int in = out + 1; in < words.length; in++) {
				if (strings[out].compareTo(strings[in]) == 1) {
					String temp = numbers[out];
					numbers[out] = numbers[in];
					numbers[in] = temp;
				}
			}
		}

		for (int i = 0; i < result.length; i++) {
			if (i < indexSpecial) {
				result[i] = specials[i];
			} else if (i < indexSpecial + indexNumber) {
				result[i] = numbers[i - indexSpecial];
			} else {
				result[i] = words[i - indexNumber - indexSpecial];
			}
		}

		if (Sort.DESC.equals(sort)) {
			for (int i = 0; i < result.length / 2; i++) {
				String temp = result[i];
				result[i] = result[result.length - 1 - i];
				result[result.length - 1 - i] = temp;
			}
		}

		return result;
	}
}


