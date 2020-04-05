package views;

import java.text.Normalizer;
import java.util.Scanner;

public class Ex01 {
	public static final char SPACE = ' ';
	public static final char TAB = '\t';
	public static final char BREAK_LINE = '\n';

	public static void main(String[] args) {
		String string = null;
		String check = null;
		while (true) {
			try {
				string = input("Xin mời nhập chuỗi:");
				check = removeAccent(string);
				isValidName(check);
				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		int count = count_String(string);
		System.out.println(count);
	}

	static String input(String a) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập " + a);
		String string = ip.nextLine();
		return string;
	}

	public static String removeAccent(String s) {

		String tmp = Normalizer.normalize(s, Normalizer.Form.NFD);
		return tmp.replaceAll("[^\\p{ASCII}]", "");
	}

	private static boolean isValidName(String name) {
		if (!name.matches("^[a-z A-Z]+")) {
			throw new RuntimeException("Họ tên không được chứa kí tự số, kí tự đặc biệt!");
		}
		return true;
	}

	public static int count_String(String input) {
		if (input == null) {
			return -1;
		}
		int count = 0;
		int size = input.length();
		boolean check = true;
		for (int i = 0; i < size; i++) {
			if (input.charAt(i) != SPACE && input.charAt(i) != TAB && input.charAt(i) != BREAK_LINE) {
				if (check) {
					count++;
					check = false;
				}
			} else {
				check = true;
			}
		}
		return count;
	}
}
