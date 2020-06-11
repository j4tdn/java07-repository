package generic.type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("A");
		strings.add("D");
		strings.add("S");
		System.out.println("size: " + strings.size());
		strings.set(2, "K");
		System.out.println("Index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());
		System.out.println("=============================");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}

		System.out.println("==============================");
		strings.forEach(string -> {
			System.out.println(string);
		});
		
		System.out.println("Greater than 'E': " + count(strings, s -> "A".equals(s)));

	}

	private static <E> int count(FakeList<E> list, Predicate<E> pre) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (pre.test(list.get(i))) {
				count++;
			}
		}
		return count;
	}
}
