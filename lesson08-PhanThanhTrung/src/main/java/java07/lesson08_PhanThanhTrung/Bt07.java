package java07.lesson08_PhanThanhTrung;

public class Bt07 {
	public static void main(String[] args) {
		String s = "aabbbaaabbbbaaac";
		int end = 0;
		int len = 0;
		int max = 0;
		int min = 999;
		int end2 = 0;
		int len2 = 1;

		for (int i = 0; i < s.length(); i++) {

			if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {

				if (max <= len) {
					max = len + 1;
					end = i;

				}
				len = 0;
			} else {
				len++;
			}

		}
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {

				if (min >= len2) {

					min = len2;
					end2 = i;

				}
				len2 = 1;
			} else {
				len2++;
			}
		}

		System.out.print("Xâu con có độ dài dài nhất là: " + max + " ");
		for (int i = end - max + 1; i <= end; i++) {
			System.out.print(s.charAt(i));
		}
		System.out.println(" [" + (end - max + 1) + "]");

		System.out.print("Xâu con có độ dài dài nhất là: " + min + " ");
		for (int i = end2 - min + 1; i <= end2; i++) {
			System.out.print(s.charAt(i));
		}
		System.out.print(" [" + (end2 - min + 1) + "]");

	}
}
