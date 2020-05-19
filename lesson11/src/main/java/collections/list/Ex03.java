package collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex03 {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Random rd = new Random();
		do {
			int number = rd.nextInt(10) + 1;
			if (contains(numbers, number)) {
				numbers.add(number);
			}

		}

		while (numbers.size() < 5);
		Loop(numbers);
	}
	
	private static void Loop(List<Integer> numbers) {
		//for index
		for(int i=0;i<numbers.size();i++) {
			
			System.out.print(numbers.get(i));
		}
		System.out.println();
		//for each
		for(int number:numbers) {
			System.out.print(number);
		}
	}

	private static boolean contains(List<Integer> numbers, int number) {

		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) == number) {
				return false;
			}
		}
		return true;

	}
}
