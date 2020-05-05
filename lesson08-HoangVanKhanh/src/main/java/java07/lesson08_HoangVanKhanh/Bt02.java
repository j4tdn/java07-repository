package java07.lesson08_HoangVanKhanh;

import java.util.Scanner;

public class Bt02 {
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.println("Nhập vào Họ Và Tên");
		String name = scaner.nextLine();

		String[] arrays = name.split("[\\s]+");
		for (String array : arrays) {
			name = array.substring(0, 1).toUpperCase() + array.substring(1).toLowerCase();
			System.out.print(" " + name);

		}
	}

}
