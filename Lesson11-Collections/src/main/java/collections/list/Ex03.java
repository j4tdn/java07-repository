package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Random rd = new Random();

		int size = 5;
		int count = 0;
		while (count < size) {
			int rand = rd.nextInt(10) + 1;
			if (!numbers.contains(rand)) {
				numbers.add(rand);
				count++;
			}
		}
		//numbers.forEach(number -> System.out.print(number + " "));
		loop(numbers);
	}
	
	private static void loop(List<Integer> digits) {
		// for index
		System.out.println("==========Index============");
		for (int i = 0; i < digits.size(); i++) {
			System.out.print(digits.get(i) + " ");
		}
		
		// for each
		System.out.println("\n==========Each============");
		for (Integer digit : digits) {
			System.out.print(digit + " ");
		}
		
		// iterator, iterable
		System.out.println("\n==========Iterator============");
		Iterator<Integer> iterator = digits.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}
