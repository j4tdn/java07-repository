package date02;

public class Ex01 {
	public static void main(String[] args) {
		name();
	}

	public static void name() {
		int n = 3;
		for (int i = 0; i < 2 * n - 1; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				if (i < n && (i >= j || j >= 2 * n - 1 - (i + 1))) {
					System.out.print(j + 1+" ");
				} else if (i >= n && (i <= j || j < 2 * n - 1 - i)) {
					System.out.print(j + 1+" ");
				} else {
					System.out.print("  ");
				}

			}
			System.out.println("\n");
		}

	}

}
