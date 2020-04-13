package exercise;

public class Ex05 {
	public static void main(String[] args) {
		String string1 = "ABCMTPOABCDEF";
		String string2 = "ABCTXABCDEF";

		getTheLongestCommonSubstring(string1, string2);
	}

	private static void getTheLongestCommonSubstring(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();

		int max = 0;
		int temp = 0;

		String result = "";

		int[][] array = new int[len1][len2];

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					if (i == 0 || j == 0) {
						array[i][j] = 1;
					} else {
						array[i][j] = array[i - 1][j - 1] + 1;
					}
					if (max < array[i][j]) {
						max = array[i][j];
						temp = i;
					}
				}
			}
		}

		char[] charSequence = str1.toCharArray();
		for (int k = temp - max + 1; k <= temp; k++) {
			result += charSequence[k];
		}
		System.out.println(result);
	}
}
