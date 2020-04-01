package views;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex02 {
	public static void main(String[] args) {
		String name = null;
		String check = null;
		while (true) {
			try {
				name = input("Họ tên:");
				check = removeAccent(name);
				isValidName(check);
				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Chuỗi sau khi viết hoa chữ cái đầu:" + toUpper(name));
		name = toUpper(name);
		System.out.println("Chuỗi hoàn thiện sau khi xóa kí tự trắng:" + one_Space(name));

	}

	// Hàm chuyển nhiều ký tự space thành một
	public static String one_Space(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		return str;
	}

	// Hàm chuyển chữ cái đầu thành hoa
	public static String toUpper(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i])) {

				found = false;
			}
		}
		return String.valueOf(chars);
	}

	// kiểm tra tên chỉ chứa kí tự chữ
	private static boolean isValidName(String name) {
		if (!name.matches("^[a-z A-Z]+")) {
			throw new RuntimeException("Họ tên không được chứa kí tự số, kí tự đặc biệt!");
		}
		return true;
	}

	// Chuyển có dấu sang không dấu
	public static String removeAccent(String s) {

		String tmp = Normalizer.normalize(s, Normalizer.Form.NFD);
		return tmp.replaceAll("[^\\p{ASCII}]", "");
	}

	static String input(String a) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập " + a);
		String string = ip.nextLine();
		return string;
	}

}
