package collections.list;

import java.util.Random;

public class Ex04 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length;) {
			int rand = rd.nextInt(5) + 1;
			if (!contains(numbers, rand)) {
				numbers[i] = rand;
				i++;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + "\t");
		}

	}

	private static boolean contains(int[] numbers, int rand) {
		for (int num : numbers) {
			if (num == rand) {
				return true;
			}
		}
		return false;
	}
}
