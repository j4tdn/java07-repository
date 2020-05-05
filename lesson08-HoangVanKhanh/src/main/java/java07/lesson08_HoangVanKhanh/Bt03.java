package java07.lesson08_HoangVanKhanh;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bt03 {
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.println("Nhập vào chuỗi bất kỳ :");
		String input = scaner.nextLine();

		System.out.println(removeAccent(input));

	}

	public static String removeAccent(String s) {

		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("");
	}

}
