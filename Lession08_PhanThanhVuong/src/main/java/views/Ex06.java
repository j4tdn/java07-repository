package views;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập giá trị cần tìm:");
		int index = sc.nextInt();
		System.out.println(getnumber(index));
	}

	private static char getnumber(int index) {
		int count = 1;
		String numberString = "";
		while (count <= index) {
			numberString = numberString + count;
			count++;
		}
		char[] result = numberString.toCharArray();
		for (char character : result) {
			System.out.print(character);
		}
		System.out.println();
		if (index <= 9) {
			return result[index - 1];
		}
		return result[index];
	}
}
