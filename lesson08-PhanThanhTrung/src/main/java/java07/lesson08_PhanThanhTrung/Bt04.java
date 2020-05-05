package java07.lesson08_PhanThanhTrung;

public class Bt04 {
	public static void main(String args[]) {
		int num1 = 15;
		int num2 = 8;
		System.out.println(divisor(num1));
		System.out.println(divisor(num2));
		String s1 = divisor(num1);
		String[] s2 = new String[divisor(num2).length()];
		for (int i = 0; i < divisor(num2).length(); i++) {
			s2[i] = divisor(num2).substring(i, i + 1);
			if (s1.contains(s2[i])) {
				System.out.println("YES");
				System.exit(0);
			}
		}
		System.out.println("NO");
	}

	private static boolean checkNguyenTo(int num) {
		if (num <= 2) {
			return true;
		} else {
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static String divisor(int n) {
		String str = "";
		for (int i = 2; i <= n; i++) {
			while (checkNguyenTo(i) && (n % i == 0)) {
				str += String.valueOf(i);
				n /= i;
			}
		}
		return str;
	}

}
