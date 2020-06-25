package date02;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập n = ");
		int n = Integer.parseInt(sc.nextLine());
		symmetricalTriangle(n);
	}

	private static void symmetricalTriangle(int n) {
		int tmp = 2 * n - 1;
		for (int i = 1; i <= (2 * n - 1) / 2 + 1; i++) {
			draw(tmp, i, n);
			tmp--;
		}
		tmp = (2 * n - 1) / 2 + 2;
		for (int i = (2 * n - 1) / 2; i >= 1; i--) {
			draw(tmp, i, n);
			tmp++;
		}
	}

	private static void draw(int tmp, int i, int n) {
		for (int j = 1; j <= 2 * n - 1; j++) {
			if (j <= i || j >= tmp) {
				System.out.print(j + " ");
			} else if (j > i && j < tmp) {
				System.out.print("  ");
			}
		}
		System.out.println();
	}
}