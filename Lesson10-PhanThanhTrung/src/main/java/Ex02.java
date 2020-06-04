
public class Ex02 {
	public static void main(String[] args) {
		int count = 0;// so hàng
		int[][] numbers = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 0, 6, 5 }, { 1, 2, 4, 5 } };
		//tự sửa số 0 thành số khác để kiểm tra cái cớ bản nhé.
		int[][] zero = getZerosPos(numbers);// tao mang moi de in ra
		for (int i = 0; i < zero.length; i++) {
			for (int j = 0; j < zero[i].length; j++) {
				System.out.print(zero[i][j] + " ");
			}
			System.out.println();
		}
		while (count < zero.length) {
			changesToZero(numbers, zero[count][0], zero[count++][1]);
		}
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] getZerosPos(int[][] numbers) {
		int row = numbers.length * numbers[0].length;
		int col = 2;
		int count = 0;// số hàng ko phải biến đếm
		int[][] zeroPos = new int[row][col];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {// chạy theo cột thứ i
				if (numbers[i][j] == 0) {
					zeroPos[count][0] = i;// hàng thứ count cột đầu tiên || 00 01
					zeroPos[count++][1] = j;// hàng thứ count cột thứ 2 || 10 11
				}
			}
		}
		int newArr[][] = new int[count][2];
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 2; j++) {
				newArr[i][j] = zeroPos[i][j];
			}
		}
		return newArr;
	}

	private static void changesToZero(int[][] numbers, int row, int col) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {

				if (i == row || j == col) {
					numbers[i][j] = 0;
				}

			}
		}

	}

}
