package java07.lesson08_PhanThanhTrung;

import java.util.Scanner;

public class Bt02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào họ tên");
		String str = sc.nextLine();

		String[] strarr = str.split(" ");
		String str1 = "";
		for (String strr : strarr) {
			str1 = str1 + (strr.substring(0, 1).toUpperCase() + strr.substring(1).toLowerCase());
			str1 = str1 + " ";

		}
		System.out.println("sau khi biến dổi: " + str1);
	}
}
