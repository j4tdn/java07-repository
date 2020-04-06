package exercise;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String account = "HoLong";
		System.out.println("Your account is: " + account);
		System.out.println("Enter new password: ");
		String newPass = scanner.nextLine();
	}
	
	private static void checkNewPass(String newPass, String account) {
		if (newPass.length() < 8) {
			System.out.println("Password is not valid");
		}
		else {
			
		}
	}
}
