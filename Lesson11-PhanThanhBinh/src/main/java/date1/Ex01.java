package date1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ex01 {

	private static int number = 5;
	private static Random random = new Random();

	public static void main(String[] args) {
		List<Integer> digits = mockData();
		int result = leastCommonMultipleList(digits);
		int max2nd = getMax2nd(digits);
		int sum = digits.get(0) + digits.get(digits.size() - 1);
		System.out.println("Least Common Multiple: " + result);
		System.out.println("Max 2nd: " + max2nd);
		System.out.println("Sum of element first and last: " + sum);
	}

	private static List<Integer> mockData() {
		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			int digit = 10 + random.nextInt(91);
			digits.add(digit);
		}
		return digits;
	}

	private static int leastCommonMultipleList(List<Integer> digits) {
		int result = leastCommonMultiple(digits.get(0), digits.get(1));
		for (int i = 2; i < digits.size(); i++) {
			result = leastCommonMultiple(result, digits.get(i));
		}
		return result;
	}

	private static int leastCommonMultiple(int a, int b) {
		int mul = a * b;
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}

		return mul / a;
	}

	private static int getMax2nd(List<Integer> digits) {
		int max = digits.get(0) > digits.get(1) ? digits.get(0) : digits.get(1);
		int max2 = digits.get(0) > digits.get(1) ? digits.get(1) : digits.get(0);

		for (Integer digit : digits) {
			if (max < digit) {
				max2 = max;
				max = digit;
			} else if (digit != max && max2 < digit) {
				max2 = digit;
			}
		}
		return max2;
	}
}
