package views;

import java.text.Normalizer;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		String string = input();
		System.out.println(formatString(string));
	}

	private static String formatString(String s) {
		String tmp = Normalizer.normalize(s, Normalizer.Form.NFD);
		return tmp.replaceAll("[^\\p{ASCII}]", "");
	}

	private static String input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào chuỗi: ");
		String string;

		do {
			string = input.nextLine().trim();
			if (!isValidInputString(string)) {
				System.out.println("Chuỗi không hợp lệ, Nhập lại chuỗi: ");
			}

		} while (!isValidInputString(string));

		return string;
	}

	private static boolean isValidInputString(String input) {
		return input.matches("[^0-9!@#$%^&*]+");
	}

}
