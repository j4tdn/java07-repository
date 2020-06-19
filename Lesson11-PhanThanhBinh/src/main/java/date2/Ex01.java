package date2;

public class Ex01 {
	
	public static void main(String[] args) {
		tritangle(6);
	}
	
	private static void tritangle(int n) {
		int start = 0;
		int end = 2*n - 1;
		int[][] matrix = new int[2*n - 1][2*n -1];
		for (int i = 0; i < matrix.length; i++) {
			if (i < n) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (j <= n - 1) {
						if (j > start) {
							System.out.print(" x ");
						} else {
							System.out.print(" "+ (j + 1) + " ");
						}
					} else {
						if (j + 1 < end) {
							System.out.print(" x ");
						} else {
							System.out.print(" "+ (j + 1) + " ");
						}
					}
				}
				System.out.println();
				start++;
				end--;
			} else {
				for (int j = 0; j < matrix[i].length; j++) {
					if (j < n - 1) {
						if (j + 1> end ) {
							System.out.print(" x ");
						} else {
							System.out.print(" "+ (j + 1) + " ");
						}
					} else {
						if (j < start) {
							System.out.print(" x ");
						} else {
							System.out.print(" "+ (j + 1) + " ");
						}
					}
				}
				System.out.println();
				start++;
				end--;
			}
		}
	}
}
