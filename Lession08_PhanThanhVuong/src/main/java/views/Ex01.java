package views;

import java.util.Scanner;

public class Ex01 {
	static char character;

	public static void main(String[] args) {
		String chuoi;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập vào chuỗi bất kỳ: ");
		chuoi = scanner.nextLine();

		System.out.println("Mỗi kí tự chuỗi vừa nhập là:");
		print_Characters(chuoi);
		System.out.println("Mỗi từ vừa nhập của chuỗi");
		print_Word(chuoi);
		reverse(chuoi);
	}

	public static void print_Characters(String string) {
		for (int i = 0; i < string.length(); i++) {
			character = string.charAt(i);
			System.out.println(character);
		}

	}

	public static void print_Word(String string) {
		for (int i = 0; i < string.length(); i++) {
			character = string.charAt(i);
			if (Character.isWhitespace(character)) {
				System.out.println();
			} else {
				System.out.print(character);
			}

		}
	}

	public static void reverse(String str) {
		int j = 0;
		int k = str.length() - 1;
		String newStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ' || i == 0) {
				j = (i != 0) ? i + 1 : i;
				while (j <= k) {
					newStr = newStr + str.charAt(j);
					j = j + 1;
				}
				newStr = newStr + " ";
				k = i - 1;
			}
		}
		System.out.println();
		System.out.println("Chuỗi đảo theo từ:");
		System.out.println(newStr);
		System.out.println("Chuỗi đảo theo kí tự:");
		for (int i = str.length() - 1; i >= 0; i--) {
			character = str.charAt(i);
			System.out.print(character);
		}
	}
}
