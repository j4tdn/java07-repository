package date01;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[][] arrays1 = { { 1, 2, 3, 4 }, { 5, 2, 8, 7 }, { 1, 9, 0, 9 }, { 2, 3, 8, 5 }, { 1, 2, 4, 5 } };
		int[][] arrays2 = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 8, 5 }, { 1, 2, 4, 5 } };
		printArrays(arrays1);

		System.out.println("==========");
		transMatrix(arrays1);
		
		System.out.println("==========");
		printArrays(arrays2);
		
		System.out.println("==========");
		advanced(arrays2);
	}
	private static void transMatrix(int[][] arrays) {
		int row = 0;
		int col = 0;
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				if (arrays[i][j] == 0) {
					row = i;
					col = j;
				}

			}
		}
		Arrays.fill(arrays[row], 0);

		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				if (j == col) {
					arrays[i][j] = 0;
				}
			}
		}
		printArrays(arrays);
	}

	private static void printArrays(int[][] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				System.out.print(arrays[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void advanced(int[][] arrays) {
		int[] arrayOfRow = new int[arrays.length];
		int[] arrayOfCol = new int[arrays[0].length];
		int countRow = 0;
		int countCol = 0;

		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				if (arrays[i][j] == 0) {
					arrayOfRow[countRow++] = i;
					arrayOfCol[countCol++] = j;
				}
			}
		}

		int[] resultarrayOfCol = Arrays.copyOfRange(arrayOfCol, 0, countCol);
		int[] resultarrayOfRow = Arrays.copyOfRange(arrayOfRow, 0, countRow);

		for (int i = 0; i < arrays.length; i++) {
			if (check(i, resultarrayOfRow)) {
				Arrays.fill(arrays[i], 0);
			}
			for (int j = 0; j < arrays[i].length; j++) {
				if (check(j, resultarrayOfCol)) {
					arrays[i][j] = 0;
				}
			}

		}
		printArrays(arrays);
	}

	private static boolean check(int n, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				return true;
			}
		}
		return false;
	}
}
