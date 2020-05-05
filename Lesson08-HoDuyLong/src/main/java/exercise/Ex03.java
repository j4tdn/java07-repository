package exercise;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		String inputString = "Tôi đi đến trường";

		removeAccent(inputString);
	}

	private static void removeAccent(String s) {
		String result = "";
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		result = pattern.matcher(temp).replaceAll("").replaceAll("đ", "d");
		System.out.println(result);
	}
}
