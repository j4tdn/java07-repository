package bt;

public class Ex04 {
	public static void main(String[] args) {
		int a = 15;
		int b = 22;

		String s1 = divisor(a);
		String[] s2 = new String[divisor(b).length()];
		for (int i = 0; i < divisor(b).length(); i++) {
			s2[i] = divisor(b).substring(i, i + 1);
			if (s1.contains(s2[i])) {
				System.out.println("YES");
				System.exit(0);
			}
		}
		System.out.println("NO");
	}

	private static String divisor(int x) {
		String s = "";
		int i = 2;
		while (x > 1 && x >= i) {
			if (x % i == 0 && checkPrimeNum(i)) {
				s += String.valueOf(i);
				x /= i;
			} else {
				i++;
			}
		}
		return s;
	}

	private static boolean checkPrimeNum(int i) {
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
}