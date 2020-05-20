package ex3;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		String[] strings = {"2", "-3", "%$", "4","aaa", "anh yeu em", "-8", "9", "*", "baikhoqua", "java07"};
		sortString(strings, Sort.ASC);
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
		sortString(strings, Sort.DESC);
		System.out.println();
		Arrays.stream(strings).forEach(string -> System.out.print(string + " "));
	}

	private static void sortString(String[] strings, Sort sort) {
		if (sort.equals(Sort.ASC)) {
			Arrays.sort(strings);
		}
		if (sort.equals(Sort.DESC)) {
			Arrays.sort(strings, (str1, str2) -> str2.compareTo(str1));
		}
	}
}

enum Sort {
	ASC, DESC
}
