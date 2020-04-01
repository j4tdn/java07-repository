package java07.lesson08_NguyenPhanThanhNhat;

import java.util.Scanner;

public class Bai6 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Dãy 1234567891011121314 ........");
		System.out.print("Nhập k: ");
		int k = ip.nextInt();
		numberAtK(k);
	}

	private static void numberAtK(int k) {
		StringBuilder s = new StringBuilder();
		if (k > 0) {
			int i = 1;
			while (s.length() < k) {
				s.append(Integer.toString(i));
				i++;
			}
			System.out.println(s);
			System.out.println("Số nằm ở vị trì thứ K trong dãy trên là: " + s.charAt(k - 1));
		}
	}
}
