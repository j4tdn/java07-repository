package Test;

import java.util.Arrays;

public class Ex03 { // WRONG
	public static void main(String[] args) {
		String str1 = "orWd";
		String str2 = "Word";
		System.out.println(compareString(str1, str2));
	}
	public static boolean compareString(String str1, String str2) {
		if (!str1.contains(str2)) {
			return false;
		}
		return true;
	}
}
