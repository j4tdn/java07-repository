package exercises;

import java.util.Scanner;

public class Ex02 {
	static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		int row, column;

		System.out.println("Nhap hang: ");
		row = Integer.parseInt(ip.nextLine());
		System.out.println("Nhap cot: ");
		column = Integer.parseInt(ip.nextLine());
		int[][] arrays = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
				arrays[i][j] = ip.nextInt();
			}
		}
		System.out.println("Mảng vừa nhập: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(arrays[i][j] + "\t");
			}
			System.out.println("\n");

		}
		matrixSwitch(arrays, row, column);
		System.out.println("Mảng vừa nhập: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(arrays[i][j] + "\t");
			}
			System.out.println("\n");

		}

	}

	private static void matrixSwitch(int[][] arrays, int row, int column) {
		boolean isValue = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arrays[i][j] == 0) {
					chagezero(arrays, row, column, i, j);
					isValue = true;
					break;
				}
			}
			if (isValue)
				break;
		}
	}
	private static void chagezero(int[][] arrays, int row, int column, int i, int j) {
		for (int x = 0; x < row; x++) {
			arrays[x][j] = 0;
		}
		for (int y = 0; y < column; y++) {
			arrays[i][y] = 0;
		}
	}

}
