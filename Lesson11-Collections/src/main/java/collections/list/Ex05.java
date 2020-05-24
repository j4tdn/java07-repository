package collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex05 {
	public static void main(String[] args) {
		List<Integer> number = random(10);
		Integer[] result = number.toArray(new Integer[number.size()]);
		

	}
	private static void printTheOddnumbers(Integer[] result) {
		for (int i = 0; i < result.length; i++) {
			if (result[i] % 2 == 0) {
				System.out.println(result[i]);
			}
		}
	}

	private static List<Integer> random(int n) {
		List<Integer> numbers = new ArrayList<>();
		Random rd = new Random();
		int i = 0;
		while (i < n) {
			int rand = rd.nextInt(10) + 1;
			if (!numbers.contains(rand)) {
				numbers.add(rand);
				i++;
			}
		}
		return numbers;
	}

}
