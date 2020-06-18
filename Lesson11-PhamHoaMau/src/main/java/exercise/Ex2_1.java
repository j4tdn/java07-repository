package exercise;

public class Ex2_1 {

	public static void main(String[] args) {
		int number = 5;
		drawTriangle(number);
	}

	private static void drawTriangle(int number) {
		int count = 1;
		for (int i = 1; i < 2 * number; i++) {
			if (count <= number) {
				drawLine(i + 1, number);
				count += 1;
				System.out.println();
			} else {
				drawLine(2 * number - i + 1, number);
				count += 1;
				System.out.println();
			}
		}
	}

	private static void drawLine(int i, int number) {
		for (int j = 1; j < 2 * number; j++) {
			if (j < i || j > 2 * number - i) {
				System.out.print(j);
			} else {
				System.out.print(" ");
			}
		}
	}
}
