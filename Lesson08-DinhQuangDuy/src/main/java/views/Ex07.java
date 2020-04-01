package views;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {

		String inputString = input();
		caculateTheLengthOfSubstring(inputString);
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

	private static void caculateTheLengthOfSubstring(String inputString) {
		int count = 0;
		int maxLength = 0;
		int minLength = 0;
		int indexOfMax = 0;
		int indexOfMin = 0;
		int sumOfLength = 0;
		int lengthOfSubstring = 0;
		int endMin = 0;
		int endMax = 0;

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

		for (String subString : strings) {
			lengthOfSubstring = subString.length();
			sumOfLength += lengthOfSubstring;

			if (lengthOfSubstring > maxLength) {
				maxLength = lengthOfSubstring;
				indexOfMax = count;
				endMax = sumOfLength;
			}

			if (lengthOfSubstring < minLength) {
				minLength = lengthOfSubstring;
				indexOfMin = count;
				endMin = sumOfLength;
			}
			count++;
		}
		System.out.println("Độ dài bé nhất của dãy con đúng: " + minLength + " " + strings[indexOfMin] + " ["
				+ (endMin - minLength) + "]");

		System.out.println("Độ dài lớn nhất của dãy con đúng: " + maxLength + " " + strings[indexOfMax] + " ["
				+ (endMax - maxLength) + "]");
	}

	private static boolean isValidInputString(String inputString) {
		return inputString.matches("[a-z]{0,255}");
	}

}
