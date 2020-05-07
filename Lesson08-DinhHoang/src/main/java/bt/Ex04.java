package bt;

public class Ex04 {
	public static void main(String[] args) {
		int firstNum = 15;
		int theSecondNum = 30;

		if (checkNum(firstNum, theSecondNum)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean checkNum(int firstNum, int theSecondNum) {
		String[] s1 = divisor(firstNum).split(" ");
		String[] s2 = divisor(theSecondNum).split(" ");
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				if (s1[i].equals(s2[j])) {
					return true;
				}
			}
		}
		return false;
	}

	private static String divisor(int number) {
		String s = "";
		int i = 2;
		while (number >= i) {
			if (number % i == 0 && checkPrimeNum(i)) {
				s += String.valueOf(i) + " ";
				number /= i;
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