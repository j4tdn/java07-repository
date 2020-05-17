package array_multiple;

public class Ex01 {
	public static void main(String[] args) {
		int[][] digits = new int[4][2];
		int[][] numbers = { { 2, 5 }, { 3, 5 }, { 4, 5 }, { 5, 7 } };
		
		for(int row =0;row <numbers.length;row++) {
			for(int col =0;col<numbers[row].length;col++) {
				System.out.print(numbers[row][col] + " ");
				
			}
			System.out.println();
		}
	}

}
