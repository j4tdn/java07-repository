package java07.Lesson09_Submit;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Bai2 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhập n: ");
		int n = Integer.parseInt(ip.nextLine());
		String[] stringArray = new String[n];
		int[] maxNumbers = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập xâu " + (i + 1) + " : ");
			stringArray[i] = ip.nextLine();
			maxNumbers[i] = getMaxNumber(stringArray[i]);
		}
		System.out.print("Kết quả: ");
		sort(maxNumbers);
	}

	private static int getMaxNumber(String s) {
		String numberString = s.trim().replaceAll("[^0-9]", " ");
		String[] numberArray = numberString.trim().replaceAll("[ ]+", " ").split("[\\s]+");
		int max = 0, number;
		for (int i = 0; i < numberArray.length; i++) {
			number = Integer.parseInt(numberArray[i]);
			if (max < number) {
				max = number;
			}
		}
		return max;
	}

	private static void sort(int[] values) {
		int tmp;
		for (int i = 0; i < values.length; i++) {
			for (int j = values.length - 1; j > i; j--) {
				if (values[j] < values[j - 1]) {
					tmp = values[j];
					values[j] = values[j - 1];
					values[j - 1] = tmp;
				}
			}
			System.out.print(values[i] + "  ");
		}
	}
}
