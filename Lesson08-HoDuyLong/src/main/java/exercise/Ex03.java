package exercise;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		String inputString = "Xin chào các bạn";

		removeAccent(inputString);
	}

	private static void removeAccent(String s) {
		String result = "";
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		result = pattern.matcher(temp).replaceAll("");
		System.out.println(result);
	}
}
