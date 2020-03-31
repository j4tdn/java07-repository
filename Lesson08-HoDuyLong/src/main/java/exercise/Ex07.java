package exercise;

import java.util.ArrayList;
import java.util.List;

public class Ex07 {
	public static void main(String[] args) {
		String inputString = "aaaaabbbab";

		rightSubstring(inputString);
	}

	private static void rightSubstring(String s) {
		List<String> list = new ArrayList<String>();
		int j = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				list.add(s.substring(j, i + 1));
				j = i + 1;
			}
		}
		list.add(s.substring(j, s.length()));
		int max = 0, min = list.get(0).length();
		for (String str : list) {
			if (max < str.length()) {
				max = str.length();
			}
			if (min > str.length()) {
				min = str.length();
			}
		}
		System.out.println("max: " + max + " and min: " + min);
	}
}
