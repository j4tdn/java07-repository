package test_02;

import java.util.Scanner;

public class Ex04 {

	static final Scanner INPUT = new Scanner(System.in);
	static final String PASSWORD_DEFAULT = "admin123";

	public static void main(String[] args) {
		System.out.print("Enter user name: ");
		String inputUserName = INPUT.nextLine();
		System.out.println("Password default is admin123, you must change password now! ");
		inputPassword(inputUserName);
	}

	private static String inputPassword(String inputUserName) {

		String inputPassword = "";
		System.out.print("Enter password: ");
		do {
			inputPassword = INPUT.nextLine();
			if (!isValidPassword(inputPassword, inputUserName)) {
				System.out.print("Enter input string valid (Ex: Dinhquangduy1@) ");
			}
		} while (!isValidPassword(inputPassword, inputUserName));
		System.out.println("Update password successfully!");
		return inputPassword;
	}

	private static boolean isValidPassword(String inputPassword, String inputUserName) {
		int count = 0;
		for (char element : inputPassword.toLowerCase().toCharArray()) {
			for (char elementOfPasswordDefault : inputUserName.toLowerCase().toCharArray()) {
				if (element == elementOfPasswordDefault) {
					count++;
					break;
				}
			}
		}

		return inputPassword.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*]).{8,}$") && count < 3;
	}

}
