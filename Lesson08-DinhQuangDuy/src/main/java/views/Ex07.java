package views;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {

		caculateTheLengthOfSubstringOne("aaabbaaabbaaaaa");
	}

	private static String input() {
		Scanner input = new Scanner(System.in);
		String inputString;
		System.out.print("Nhập vào chuỗi: ");
		do {
			inputString = input.nextLine();
			if (!isValidInputString(inputString)) {
				System.out.print("Chuỗi không hợp lệ, nhập lại chuỗi: ");
			}
		} while (!isValidInputString(inputString));
		return inputString;
	}

	private static void caculateTheLengthOfSubstringOne(String inputString) {
		int count = 0;
		int maxLength = 0;
		int minLength = 0;
		int lastIndexOfMax = 0;
		int lastIndexOfMin = 0;

		StringBuffer stringBuffer = new StringBuffer();
		char previousCharacter = inputString.charAt(0);

		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) != previousCharacter) {
				stringBuffer.append("-");
			}

			stringBuffer.append(inputString.charAt(i));
			previousCharacter = inputString.charAt(i);
		}

		String[] strings = stringBuffer.toString().split("-");

		maxLength = minLength = strings[0].length();
		int length = 0;
		for (String subString : strings) {
			length = subString.length();
			if (length >= maxLength) {
				maxLength = length;
				lastIndexOfMax = count;
			}
			if (length <= minLength) {
				minLength = length;
				lastIndexOfMin = count;
			}
			count++;
		}
		System.out.println(stringBuffer);

		System.out.println("Độ dài bé nhất của dãy con đúng: " + minLength + " " + strings[lastIndexOfMin]);

		System.out.println("Độ dài lớn nhất của dãy con đúng: " + maxLength + " " + strings[lastIndexOfMax]);
	}

	private static boolean isValidInputString(String inputString) {
		return inputString.matches("[a-z]{0,255}");
	}

}
