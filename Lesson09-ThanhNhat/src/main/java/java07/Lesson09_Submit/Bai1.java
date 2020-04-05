package java07.Lesson09_Submit;

import java.util.Scanner;

public class Bai1 {
	private static Scanner ip = new Scanner(System.in);
	private static boolean ISVALID = false;

	public static void main(String[] args) {
		String s = null;
		while (true) {
			try {
				s = ip.nextLine();
				ISVALID = isValidString(s);
				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}

		String[] wordArray = s.split("[\\s]+");
		System.out.println(wordArray.length + " words");
	}

	private static boolean isValidString(String s) {
		if (isWord(s) == false) {
			throw new RuntimeException("Chuỗi chỉ chứa các kí tự khoảng trắng hoặc [A-Za-z]!");
		}
		return true;
	}

	private static boolean isWord(String s) {
		for (char c : s.toCharArray()) {
			if (c < ' ' || (c > ' ' && c < 'A') || (c > 'Z' && c < 'a') || c > 'z')
				return false;
		}
		return true;
	}
}
