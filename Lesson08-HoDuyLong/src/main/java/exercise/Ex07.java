package exercise;

import java.util.ArrayList;
import java.util.List;

public class Ex07 {
	public static void main(String[] args) {
		String inputString = "aaabaaabbaaaaa";

		maxAndMinOfRightSubStr(inputString);
	}

	private static void maxAndMinOfRightSubStr(String s) {
		List<String> list = new ArrayList<String>();
		int j = 0;
		String maxRightSubStr = "";
		String minRightSubStr = "";

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
				maxRightSubStr = str;
			}
			if (min > str.length()) {
				min = str.length();
				minRightSubStr = str;
			}
		}
		System.out.println("max: " + max + " " + maxRightSubStr + " and min: " + min + " " + minRightSubStr);
	}
}
