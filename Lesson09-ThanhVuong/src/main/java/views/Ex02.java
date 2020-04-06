package views;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Xin mời nhập ");
		int number = Integer.parseInt(sc.nextLine());
		String[] inputStrings = inputString(number);

		for (int max : searchNumberStringMax(inputStrings)) {
			System.out.print(max + ",");
		}

	}

	private static int[] searchNumberStringMax(String[] string) {
		int[] numberStringMaxs = new int[string.length];
		for (int i = 0; i < string.length; i++) {
			numberStringMaxs[i] = searchNumberStringMaxInString(string[i]);
		}
		Arrays.sort(numberStringMaxs);
		return numberStringMaxs;
	}

	private static int searchNumberStringMaxInString(String inputString) {
		inputString = inputString.replaceFirst("[a-z]+", "").trim();

		if (inputString == null || !isHaveDigitInString(inputString)) {
			return 0;
		}

		String[] numberStrings = inputString.split("[a-z]+");
		int max = Integer.parseInt(numberStrings[0]);

		for (String numberString : numberStrings) {
			if (Integer.parseInt(numberString) > max) {
				max = Integer.parseInt(numberString);
			}
		}

		return max;
	}

	private static String[] inputString(int number) {
		Scanner sc = new Scanner(System.in);

		String[] inputStrings = new String[number];

		for (int i = 0; i < inputStrings.length; i++) {
			System.out.print("Enter input string " + i + " : ");
			do {
				inputStrings[i] = sc.nextLine();
				if (!isValid(inputStrings[i])) {
					System.out.print("Enter input string valid (a-zAZ) ");
				}
			} while (!isValid(inputStrings[i]));
		}
		return inputStrings;
	}

	private static boolean isHaveDigitInString(String inputString) {
		for (char element : inputString.toCharArray()) {
			if (Character.isDigit(element)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isValid(String inputString) {

		return inputString.matches("[a-z0-9]+");
	}

}
