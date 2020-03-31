package exercise;

import java.util.Arrays;

public class Ex04 {
	public static void main(String[] args) {
		int number1 = 15;
	    int number2 = 75;
		System.out.println("Is equivalent prime number: " + Arrays.equals(getDivisor(number1), getDivisor(number2)));
	}

	private static int[] getDivisor(int number) {
		int count = 1;
		int length = 0;
		while (count <= number) {
			if (number % count == 0 && isPrimeNumber(count)) {
				length++;
			}
			count++;
		}
		int[] divisors = new int[length];
		count = 1;
		int index = 0;
		while (count <= number) {
			if (number % count == 0 && isPrimeNumber(count)) {
				divisors[index] = count;
				index++;
			}
			count++;
		}
		return divisors;
	}

	private static boolean isPrimeNumber(int number) {
		int count = 0;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				count++;
			}
		}
		return count == 0 ? true : false;
	}
}
