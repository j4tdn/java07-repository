package exercises;

import java.util.Arrays;

public class Ex02 {
	public static void main(String[] args) {
		
		int[][] numbers = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		outputArrays(numbers);
		for (int row = 0; row < numbers.length; row++) {
			for (int col = 0; col < numbers[row].length; col++) {
				System.out.print(numbers[row][col] + " ");
			}
			System.out.println();
		}
	}
	

	private static int[][] outputArrays(int[][] numbers) {
		int[][] xs= new int[localtionOfZeros(numbers).length][2];
		for(int row=0;row<xs.length;row++) {
			for(int col=0;col<xs[row].length;col++) {
				xs[row][col]=localtionOfZeros(numbers)[row][col];
			}
		}
		for(int i=0;i<xs.length;i++) {
			for(int j=0;j<numbers[0].length;j++) {
				numbers[xs[i][0]][j]=0;	
			}
			for(int j=0;j<numbers.length;j++) {
				numbers[j][xs[i][1]]=0;
			}
		}
		return numbers;
	}
	

	private static int[][] localtionOfZeros(int[][] numbers) {
		int[][] zeroArrays = new int[numbers.length * numbers[0].length][2];
		int index = 0;
		for (int row = 0; row < numbers.length; row++) {
			for (int col = 0; col < numbers[row].length; col++) {
				if (numbers[row][col] == 0) {
					zeroArrays[index][0] = row;
					zeroArrays[index][1] = col;
					index++;
				}
			}
		}
		int[][] localtionOfZeroArrays = new int[index][2];
		for (int row = 0; row < localtionOfZeroArrays.length; row++) {
			for (int col = 0; col < localtionOfZeroArrays[row].length; col++) {
				localtionOfZeroArrays[row][col] = zeroArrays[row][col];
			}
		}
		return localtionOfZeroArrays;
	}
}