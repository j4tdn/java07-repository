package views;

import java.util.Scanner;

public class Ex05 {
	static void printLCSubStr(String X, String Y) {
		int[][] lenght_string = new int[X.length() + 1][Y.length() + 1];// tạo mảng lưu độ dài chung nhất
		int len = 0;
		int row = 0, col = 0;
		for (int i = 0; i <= X.length(); i++) {
			for (int j = 0; j <= Y.length(); j++) {
				if (i == 0 || j == 0)
					lenght_string[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					lenght_string[i][j] = lenght_string[i - 1][j - 1] + 1;
					if (len < lenght_string[i][j]) {
						len = lenght_string[i][j];
						row = i;
						col = j;
					}
				} else
					lenght_string[i][j] = 0;
			}
		}
		if (len == 0) {
			System.out.println("No Common Substring");
			return;
		}
		String resultStr = "";
		while (lenght_string[row][col] != 0) {
			resultStr = X.charAt(row - 1) + resultStr;
			--len;
			row--;
			col--;
		}
		System.out.println(resultStr);
	}

	private static boolean isValidInput(String string) {

		return string.matches("[A-Za-z]{1,250}");
	}

	private static String input() {
		Scanner input = new Scanner(System.in);
		System.out.println("nhập vào chuỗi: ");
		String string;

		do {
			string = input.nextLine().trim();
			if (!isValidInput(string)) {
				System.out.println("Vui lòng nhập lại chuỗi: ");
			}
		} while (!isValidInput(string));
		return string;
	}

	public static void main(String args[]) {
		String One = input();
		String Two = input();

		printLCSubStr(One, Two);
	}
}