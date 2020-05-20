package exercises;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 9, 5, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		int[][] result = transfer(matrix);

		printMatrix(result);

		System.out.println("============Advanced==============");
		int[][] matrix1 = { { 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1 } };
		int[][] result1 = advancedTransfer(matrix1);
		printMatrix(result1);
	}

	private static int[][] transfer(int[][] matrix) {
		int index1 = 0;
		int index2 = 0;

		firstLoop: for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					index1 = i;
					index2 = j;
					break firstLoop;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][index2] = 0;
		}
		for (int i = 0; i < matrix[index1].length; i++) {
			matrix[index1][i] = 0;
		}
		return matrix;
	}

	private static int[][] advancedTransfer(int[][] matrix) {
		int[] zeroIndexs = new int[matrix.length * matrix[0].length];
		int index = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					zeroIndexs[index++] = i;
					zeroIndexs[index++] = j;
				}
			}
		}
		zeroIndexs = Arrays.copyOfRange(zeroIndexs, 0, index);
		for (int i = 0; i < zeroIndexs.length; i += 2) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[zeroIndexs[i]][j] = 0;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < zeroIndexs.length; j += 2) {
				matrix[i][zeroIndexs[j]] = 0;
			}
		}
		return matrix;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
