package generics.type;

import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<String>();
		strings.add("hello");
		strings.add("Kai");
		strings.add("Do");

		System.out.println("size: " + strings.size());
		strings.set(2, "DODODO");
		System.out.println("Index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());

		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		System.out.println("Greater than E" + count(strings, s -> s.compareTo("B") > 0));
	}

	private static <E extends Comparable<E>> int count(FakeList<E> list, Predicate<E> pre) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (pre.test(list.get(i))) {
				count++;
			}
		}
		return count;
	}
}