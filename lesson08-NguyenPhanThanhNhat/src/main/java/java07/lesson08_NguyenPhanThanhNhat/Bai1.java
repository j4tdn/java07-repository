package java07.lesson08_NguyenPhanThanhNhat;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai1 {
	private static Scanner ip = new Scanner(System.in);
	private static boolean ISVALID = false;

	public static void main(String[] args) {
		String s = null;
		while (true) {
			try {
				s = ip.nextLine();
				ISVALID = isValidString(covertToString(s));
				break;
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Chuỗi: " + s);
		s = s.trim().replaceAll("[ ]+", " ");

		System.out.println("In ra mỗi kí tự trên một dòng:");
		for (char c : s.toCharArray()) {
			if (c == ' ')
				continue;
			System.out.println(c);
		}

		System.out.println("In ra mỗi từ trên mỗi dòng:");
		String[] wordArray = s.split("[\\s]");
		for (String word : wordArray) {
			System.out.println(word);
		}

		System.out.print("Chuỗi đảo ngược theo từ: ");
		String[] reverseArray = new String[wordArray.length];
		int j = 0;
		for (int i = wordArray.length - 1; i >= 0; i--) {
			reverseArray[j] = wordArray[i];
			j++;
		}
		String reverseString = String.join(" ", reverseArray);
		System.out.println(reverseString);

		System.out.print("Chuỗi đảo ngược theo kí tự: ");
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
	}

	// Source : https://teamvietdev.com/mot-so-ham-chuyen-doi-ky-tu-trong-java/
	public static String covertToString(String value) {
		try {
			String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private static boolean isValidString(String s) {
		if (isWord(covertToString(s)) == false) {
			throw new RuntimeException("Chuỗi chỉ chứa các kí tự tiếng Việt có dấu, phím space!");
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
