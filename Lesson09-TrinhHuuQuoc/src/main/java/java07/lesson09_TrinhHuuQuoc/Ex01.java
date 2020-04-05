package java07.lesson09_TrinhHuuQuoc;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println("Nhập vào chuỗi:");
		Scanner scanner = new Scanner(System.in);
		String inputText = scanner.nextLine();

		int countWord = 0;
		inputText = " " + inputText;
		for (int i = 0; i < inputText.length() - 1; i++) {
			if (i == inputText.length() - 1) {
				countWord += 0;
			} else {
				if (inputText.charAt(i) == ' ') {
					if ((inputText.charAt(i + 1) == '\n') || (inputText.charAt(i + 1) == ' ')) {
						countWord += 0;
					} else {
						countWord++;
					}
				}
			}
		}
		System.out.println("Số từ trong câu là: " + countWord);
	}
}
