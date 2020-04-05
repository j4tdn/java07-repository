package java07.Lesson09_PhamHoaMau;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		String[] input = new String[2];
		input[0] = "dgasjh123askjdh1231324";
		input[1] = "ajskdhkj12231ssadn21312";
		int[] maxNumber = new int[input.length];

		showMaxNumber(maxNumber, input);
	}

	private static void showMaxNumber(int[] maxNumber, String[] input) {
		for (int i = 0; i < input.length; i++) {
			maxNumber[i] = findMaxNumberInString(input[i]);
		}
		Arrays.sort(maxNumber);
		for (int i = 0; i < maxNumber.length; i++) {
			System.out.println(maxNumber[i]);
		}
	}

	private static int findMaxNumberInString(String input) {
		int[] number = new int[100];
		String[] numberString;
		int max = number[0];

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				input = input.replace(input.charAt(i), (char) ' ');
			}
		}
		input = input.replaceAll("[\\s]+", " ").trim();
		numberString = input.split(" ");
		for (int i = 0; i < numberString.length; i++) {
			number[i] = Integer.parseInt(numberString[i]);
		}
		for (int i = 0; i < number.length; i++) {
			if (number[i] > max) {
				max = number[i];
			}
		}
		return max;
	}
}
