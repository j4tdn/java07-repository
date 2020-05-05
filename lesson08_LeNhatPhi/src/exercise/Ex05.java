package exercise;

public class Ex05 {
	public static void main(String[] args) {
		String string1 = "01a2b3456cde478";
		String string2 = "ABC3456ENGH";
		String count = "";
		int variableOne = 0;
		int variableTwo = 0;

		for (int i = 0; i < 20; i++) {
			if (variableTwo <= string1.length()) {
				String string3 = string1.substring(variableOne, variableTwo);
				int a = string2.indexOf(string3);
				if (a == -1) {
					if (variableTwo >= variableOne + 2) {
						variableOne++;
					} else {
						variableOne++;
						variableTwo++;
					}
				} else {
					if (variableTwo >= variableOne + 2 && string3.length() >= count.length()) {
						count = string3;
						variableTwo++;
					} else {
						variableTwo++;

					}
				}
			}
		}
		System.out.println("Chuỗi con chung dài nhất là:" + count);
	}
}
