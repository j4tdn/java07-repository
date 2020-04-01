package java07.Lesson08_PhamHoaMau;

public class Ex05 {
	public static void main(String[] args) {
		String stringFirst = "ABCEDEABC", stringSecond = "ABCEDCBBCK", results = "";
		int max = 0;
		for (int i = 0; i < stringFirst.length(); i++) {
			for (int j = i; j < stringFirst.length(); j++) {
				if (stringSecond.contains(stringFirst.substring(i, j + 1)) && max < stringFirst.substring(i, j + 1).length()) {
					max = (max < stringFirst.substring(i, j + 1).length()) ? stringFirst.substring(i, j + 1).length() : max;
					results = stringFirst.substring(i, j + 1);
				}
			}
		}
		System.out.println(results);
	}
}
