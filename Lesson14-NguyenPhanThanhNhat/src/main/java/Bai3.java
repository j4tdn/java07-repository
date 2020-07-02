import java.util.Arrays;

public class Bai3 {
	public static void main(String[] args) {

		String s1 = "Vava";
		String s2 = "Avav";
		System.out.println("Is Anagram: " + isAnagram(s1, s2));

	}

	private static boolean isAnagram(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 != len2) {
			return false;
		}

		char[] c1 = s1.toLowerCase().toCharArray();
		char[] c2 = s2.toLowerCase().toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);

		for (int i = 0; i < len1; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		return true;
	}
}
