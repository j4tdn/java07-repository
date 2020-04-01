package java07.lesson08_NguyenPhanThanhNhat;

import java.util.Scanner;

public class Bai2 {
	private static Scanner ip = new Scanner(System.in);
	private static boolean ISVALID = false;

	public static void main(String[] args) {
		String s = null;
		while (true) {
			try {
				s = ip.nextLine();
				ISVALID = isValidName(s);
				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}

		String[] wordArray = s.split("[\\s]+");
		String[] handledArray = new String[wordArray.length];
		int j = 0;
		for (String c : wordArray) {
			handledArray[j] = handling(c);
			j++;
		}
		String name = String.join(" ", handledArray);
		System.out.println(name);
	}

	private static boolean isValidName(String s) {
		if (isWord(s) == false) {
			throw new RuntimeException("Họ tên nhập vào chỉ bao gồm các kí tự [A-Za-z]!");
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

	private static String handling(String s) {
		String result = s.substring(0, 1).toUpperCase();
		result += s.substring(1).toLowerCase();
		return result;
	}
}
