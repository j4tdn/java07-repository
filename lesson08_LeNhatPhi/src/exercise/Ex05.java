package exercise;

public class Ex05 {
	public static void main(String[] args) {
		String string1 = "ABCDE123DEFGH";
		String string2 = "ABCDE123ENGH";
		String count = "";
		int s1 = 0;
		int s2 = 0;

		for (int i = 0; i < 20; i++) {
			if (s2 <= string1.length()) {
				String string3 = string1.substring(s1, s2);
				int a = string2.indexOf(string3);
				if (a == -1) {
					if (s2 >= s1 + 2) {
						s1++;
					} else {
						s1++;
						s2++;
					}
				} else {
					if (s2 >= s1 + 2 && string3.length() >= count.length()) {
						count = string3;
						s2++;
					} else {
						s2++;

					}
				}
			}
		}
		System.out.println("Chuỗi con chung dài nhất là:" + count);
	}
}
