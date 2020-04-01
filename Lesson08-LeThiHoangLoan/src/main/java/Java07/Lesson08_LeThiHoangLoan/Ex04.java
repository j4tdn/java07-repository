package Java07.Lesson08_LeThiHoangLoan;

public class Ex04 {
	public static void main(String[] args) {
		long number2 = 75;
		long number1 = 101;
		int bit = 1;

		long number = number1 > number2 ? number2 : number1;

		for (int i = 2; i <= number / 2; i++) {
			if ((check(number1, i) && !check(number2, i)) || (!check(number1, i) && check(number2, i))) {
				bit = 0;
			}
		}
		if (bit == 0) {
			System.out.println("NO");
		} else
			System.out.println("YES");

	}

	public static boolean check(long number, int n) {
		if (uoc(n, number) && isPrime(n)) {
			return true;
		}
		return false;
	}

	public static boolean isPrime(long number) {
		if (number == 2)
			return true;
		else {
			for (int j = 2; j < number; j++) {
				if (number % j == 0)
					return false;
			}
		}
		return true;
	}

	public static boolean uoc(long i, long number1) {
		if (number1 % i == 0)
			return true;
		return false;

	}
}
