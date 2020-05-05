package exercise;

import java.util.HashSet;

public class Ex04 {
	public static void main(String[] args) {
		long num1 = 15;
		long num2 = 75;
		checkEquivalentPrime(num1, num2);
	}

	private static void checkEquivalentPrime(long a, long b) {
		if (analyInt(a).equals(analyInt(b))) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static HashSet<Integer> analyInt(long n) {
		int i = 2;
		HashSet<Integer> set = new HashSet<Integer>();

		while (n > 1) {
			if (n % i == 0) {
				n = n / i;
				set.add(i);
			} else {
				i++;
			}
		}
		if (set.isEmpty()) {
			set.add((int) n);
		}
		return set;
	}
}
