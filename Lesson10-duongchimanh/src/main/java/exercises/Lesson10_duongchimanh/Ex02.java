package exercises.Lesson10_duongchimanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex02 {
	public static void main(String[] args) {
		int col = 4, row = 4;
		int[][] matrix = new int[row][col];
		List<String> markZero = new ArrayList<>();
		System.out.println("Matrix before handle: ");
		createMatrix(col, row, matrix);
		showMatrix(col, row, matrix);
		markMatrix(col, row, matrix, markZero);
		handleMatrix(col, row, matrix, markZero);
		System.out.println("Matrix after handle: ");
		showMatrix(col, row, matrix);
	}

	private static void handleMatrix(int col, int row, int[][] matrix, List<String> markZero) {
		List<Integer> colums = new ArrayList<>();
		List<Integer> rows = new ArrayList<>();
		for (String mark : markZero) {
			rows.add(Integer.parseInt(mark.substring(0, 1)));
			colums.add(Integer.parseInt(mark.substring(1, 2)));
		}
		for (Integer r : rows) {
			for (int i = 0; i < col; i++) {
				matrix[r][i] = 0;
			}
		}
		for (Integer c : colums) {
			for (int i = 0; i < row; i++) {
				matrix[i][c] = 0;
			}
		}
	}

	private static void markMatrix(int col, int row, int[][] matrix, List<String> markZero) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					markZero.add(Integer.toString(i) + Integer.toString(j));
				}
			}
		}
	}

	private static void showMatrix(int col, int row, int[][] matrix) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}

	private static void createMatrix(int col, int row, int[][] matrix) {
		Random rand = new Random();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = rand.nextInt(9);
			}
		}
	}
}
