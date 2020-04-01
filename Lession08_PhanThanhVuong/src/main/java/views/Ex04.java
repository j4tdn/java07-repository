package views;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04 {
	private static final long MAX_VALUE = 300000000000000000L;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số thứ nhất: ");
		String numberOne = inputNumber();
		System.out.print("Nhập số thứ hai: ");
		String numberTwo = inputNumber();
		System.out.println();
		System.out.println(analysis_Prime(numberOne).equals(analysis_Prime(numberTwo)) ? "YES" : "NO");

	}

	public static boolean checkPrime(int number) {
		if (number <= 2) {
			return true;
		} else {
			for (int i = 2; i < Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;

	}

	public static String analysis_Prime(String str) {
		String result = null;
		long number = Long.parseLong(str);
		for (int i = 2; i <= number; i++) {
			if (checkPrime(i) && (number % i == 0)) {
				result = result + i;
			}
			while (checkPrime(i) && (number % i == 0)) {
				number /= i;
			}

		}
		return result;
	}

	private static boolean isValidNumber(String numberString) {

		for (int i = 0; i < numberString.length(); i++) {
			if (!Character.isDigit(numberString.charAt(i))) {
				return false;
			}
		}

		return (Long.parseLong(numberString) >= 2 && Long.parseLong(numberString) <= MAX_VALUE) ? true : false;
	}

	private static String inputNumber() {
		Scanner input = new Scanner(System.in);
		String numberString;
		do {
			numberString = input.nextLine();
			if (!isValidNumber(numberString)) {
				System.out.print("Vui lòng nhập lại số (2 <= n <= 300000000000000000): ");
			}

		} while (!isValidNumber(numberString));
		return numberString;
	}

}
