package test_02;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		String inputString = inputString();
		int countWord = countWords(inputString);
		System.out.println(countWord + " words");
	}

	private static int countWords(String inputString) {
		inputString = inputString.trim();
		return inputString.split("[\\s]+").length;
	}

	private static String inputString() {
		Scanner input = new Scanner(System.in);
		String inputString = "";
		System.out.print("Enter input string: ");
		do {
			inputString = input.nextLine();
			if (!isValidInputString(inputString)) {
				System.out.print("Enter input string valid (a-zAZ) ");
			}
		} while (!isValidInputString(inputString));

		return inputString;
	}

	private static boolean isValidInputString(String inputString) {

		return inputString.matches("[a-zAZ\\s]+");
	}

}
