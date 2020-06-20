package bt.b2;

import java.util.Scanner;

public class Bai1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = scn.nextInt(), i, j;
		int[][] value = new int[n][n];
		for (i = 0; i < Math.ceil(n * 1.0 / 2); i++) {
			for (j = 0; j < Math.ceil(n * 1.0 / 2); j++) {
				if (j - i >= 0) {
					value[j][i] = 1;
					value[n - 1 - j][i] = 1;
					value[j][n - 1 - i] = 1;
					value[n - 1 - j][n - 1 - i] = 1;
				}
			}
		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (value[i][j] == 1) {
					System.out.print(j + 1 + " ");
				} else if (value[i][j] == 0) {
					System.out.print("  ");
				}
				if (j == n - 1) {
					System.out.print("\n");
				}
			}
		}
	}
}
