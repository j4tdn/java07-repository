package java07.Lesson08_PhamHoaMau;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {
		String string = "Phạm Hòa Mâu";
		String unAccent = Normalizer.normalize(string, Normalizer.Form.NFD);
		Pattern partern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		System.out.println(partern.matcher(unAccent).replaceAll(""));
	}
}
