package Java07.Lesson08_LeThiHoangLoan;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Ex03 {
	public static void main(String[] args) {

		String input = "Em có yêu anh không anh để anh biết còn chờ Em xin lỗi em đã có thái độ không đúng với anh ";
		System.out.println(covert(input));
	}

	public static String covert(String value) {
		try {
			String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
