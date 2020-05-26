package array_multiple;

public class Ex01 {
	public static void main(String[] args) {
		int[][] digits= new int[4][2];
		int[][] numbers= {{3,2},{6,4},{5,7},{9,7},{4,6}};
		for (int row = 0; row < numbers.length; row++) {
			for (int colum = 0; colum < numbers[row].length; colum++) {
				System.out.printf(numbers[row][colum]+" ");
			}
			System.out.println();
		}
	}
}
