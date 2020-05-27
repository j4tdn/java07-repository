package ex2;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };
		int[][] matrix2 = { { 1, 2, 0, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		showMaxtrix(changeMatrix(matrix));
		System.out.println("============");
		showMaxtrix(changeMatrix(matrix2));
	}

	private static void showMaxtrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] changeMatrix(int[][] matrix) {
		int[] colZero = new int[matrix[0].length];
		int index = 0;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 0) {
					Arrays.fill(matrix[row], 0);
					colZero[index++] = col;
					break;
				}
			}
		}

		colZero = Arrays.copyOfRange(colZero, 0, index);
		
		for (int row = 0; row < matrix.length; row++) {
			for (int colZeroIndex = 0; colZeroIndex < colZero.length;colZeroIndex ++) {
				matrix[row][colZero[colZeroIndex]] = 0;
			}
		}

		return matrix;
	}
}
