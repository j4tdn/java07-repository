package excercise;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		int[][] digits = { { 1, 2, 6, 9 }, { 4, 1, 6, 0 }, { 1, 2, 9, 8 }, { 7, 2, 1, 7 }, { 6, 1, 8, 2 } };
		printMatrix(digits);
		System.out.println("==================");
		converMatrix(digits);
		printMatrix(digits);
	}

	private static int[][] converMatrix(int[][] digits) {
		int rowIndex = 0;
		int colIndex = 0;
		
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[row].length; col++) {
				if (digits[row][col] == 0) {
					rowIndex = row;
					colIndex = col;
					break;
				}

			}
		}
		
		return setValueOfMatrix(digits, rowIndex, colIndex);
	}
	
	private static int[][] setValueOfMatrix(int[][] digits, int rowIndex, int colIndex) {
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[row].length; col++) {
				if ( row == rowIndex || col == colIndex) {
					digits[row][col] = 0;
				}
			}
		}
		return digits;
	}
	
	private static void printMatrix(int[][] digits) {
		
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[row].length; col++) {
				System.out.print(digits[row][col] + "  ");
			}
			System.out.println();
		}
	}
}