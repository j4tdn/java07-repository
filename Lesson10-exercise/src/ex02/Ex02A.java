package ex02;

import java.util.ArrayList;

public class Ex02A {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };
		matrix= replaceMatrix(matrix);
		// output
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				System.out.printf(matrix[row][column]+" ");
				if (column==matrix[0].length-1) {
					System.out.println();
				}
			}
		}
		
		// cau b
		System.out.println("\n======================");
		int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		matrix2= replaceMatrix(matrix2);
		// output
		for (int row = 0; row < matrix2.length; row++) {
			for (int column = 0; column < matrix2[0].length; column++) {
				System.out.printf(matrix2[row][column]+" ");
				if (column==matrix2[0].length-1) {
					System.out.println();
				}
			}
		}
	}

	private static int[][] replaceMatrix(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;

		boolean[] rowBl = new boolean[row];
		boolean[] columBl = new boolean[column];
		// find row colum 0
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == 0) {
					rowBl[i] = true;
					columBl[j] = true;
				}
			}
		}
		// set 0 for colum
		for (int i = 0; i < row; i++) {
			if (rowBl[i]) {
				for (int j = 0; j < column; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		// set 0 for row
		for (int i = 0; i < column; i++) {
			if (columBl[i]) {
				for (int j = 0; j < row; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		return matrix;
	}
}
