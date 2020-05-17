package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ex03 {
	public static void main(String[] args) {
		Random rd = new Random();
		int size = 5;
		int count = 0;
		List<Integer> numbers = new ArrayList<>();
		while (count < size) {
			int rand = rd.nextInt(10) + 1;
			if (!numbers.contains(rand)) {
				numbers.add(rand);
				count++;
			}
		}
		System.out.println("numbers size: " + numbers.size());
	//	numbers.forEach(number -> System.out.println("number: " + number));
		loop(numbers);
	}
	
	private static void loop(List<Integer> list) {
		//for index
		System.out.print("for index: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		//for each
		System.out.print("\nfor each: ");
		for(Integer number: list) {
			System.out.print(number + " ");
		}
		//iterator, interrable
		System.out.print("\niterator ");
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}	
