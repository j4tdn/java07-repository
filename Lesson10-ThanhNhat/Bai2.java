package BTDATE01;

import java.util.ArrayList;
import java.util.List;

public class Bai2 {
	public static void main(String[] args) {
		int[][] numbers = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		printMatrix(numbers);

		System.out.println();

		int[] indexesArray = convertToArray(findIndex(numbers));
		int i = 0;
		while (i < indexesArray.length) {
			convertMatrix(numbers, indexesArray[i], indexesArray[i + 1]);
			i += 2;
		}
		System.out.println("Convert Matrix:");
		printMatrix(numbers);
	}

	private static List findIndex(int[][] numbers) {
		List result = new ArrayList();
		for (int row = 0; row < numbers.length; row++) {
			for (int col = 0; col < numbers[row].length; col++) {
				if (numbers[row][col] == 0) {
					result.add(row);
					result.add(col);
				}
			}
		}
		return result;
	}

	private static void convertMatrix(int[][] numbers, int row, int col) {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i][col] = 0;
		}
		for (int j = 0; j < numbers[row].length; j++) {
			numbers[row][j] = 0;
		}
	}

	private static void printMatrix(int[][] numbers) {
		for (int row = 0; row < numbers.length; row++) {
			for (int col = 0; col < numbers[row].length; col++) {
				System.out.print(numbers[row][col] + "  ");
			}
			System.out.println();
		}
	}

	public static int[] convertToArray(List list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = Integer.parseInt(list.get(i).toString());
		}
		return array;
	}
}
