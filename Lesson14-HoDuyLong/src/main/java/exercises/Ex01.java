package exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ex01 {
	public static void main(String[] args) {
		int[] input1 = { 1, 2, 3, 4, 5, 6, 5, 5, 3, 1 };
		int[] input2 = { 5, 7, 9, 10, 20, 9, 7, 11 };

		occuredOne(input1);

		System.out.println();
		occuredMore(input2);
	}

	private static void occuredOne(int[] numbers) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				map.put(numbers[i], 1 + map.get(numbers[i]));
			} else {
				map.put(numbers[i], 1);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

	private static void occuredMore(int[] numbers) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				map.put(numbers[i], 1 + map.get(numbers[i]));
			} else {
				map.put(numbers[i], 1);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}
}
