package Java07.Lesson08_LeThiHoangLoan;

import java.util.Scanner;

public class Ex02 {
	public static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		String fullName;
		System.out.println("Nhập tên");
		while (true) {
			try {
				fullName = ipFullName();
				break;
			} catch (Exception e) {
				System.out.println("Exception :" + e.getMessage());
				System.out.println("Nhap lai Ho Ten");
			}
		}

		String[] array = fullName.toLowerCase().split(" ");

		for (String name : array) {
			for (int i = 0; i < name.length(); i++) {
				if (i == 0) {
					System.out.print(name.toUpperCase().charAt(0));
				} else {
					System.out.print(name.charAt(i));
				}
			}
			System.out.print(" ");
		}
		System.out.println("\n");

		for (String name : array) {
			for (char c : name.toCharArray()) {
				System.out.print(c + " ");
			}
		}
	}

	private static String ipFullName() throws Exception {

		String fullName = ip.nextLine();

		for (int i = 0; i < fullName.length(); i++) {

			if (fullName.charAt(i) == 32 || (fullName.charAt(i) >= 65 && fullName.charAt(i) <= 90)
					|| (fullName.charAt(i) >= 97 && fullName.charAt(i) <= 122)) {

			} else {
				throw new Exception("Ten ko duoc co so hay ki tu dac biet");
			}
		}
		return fullName;
	}
}
