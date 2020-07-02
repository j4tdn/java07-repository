package Test;

import java.util.Arrays;

public class Ex03 { // WRONG
	public static void main(String[] args) {
		String str1 = "orWd";
		String str2 = "Word";
		System.out.println(compareString(str1, str2));
	}
	public static boolean compareString(String str1, String str2) {
		int s1 = str1.length();
		int s2 = str2.length();
		if(s1!=s2) {
			return false;
		}
		return true;
	}
}
