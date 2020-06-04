package generic.type;

import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");
		System.out.println("size: " + strings.size());
		strings.set(2, "Real Item");
		System.out.println("Index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());
		System.out.println("==============================");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		System.out.println("==============================");
		strings.add("Fake Item 03");
		strings.add(1, "Fake Item Added");
		strings.forEach(string -> {
			System.out.println(string);
		});
		System.out.println("==============================");
		strings.remove(3);
		strings.remove("Fake Item Added");
		strings.forEach(string -> {
			System.out.println(string);
		});
		System.out.println("==============================");
		System.out.println("Greater than 'Fake Item 02' : " + count(strings, s -> "Fake Item 02".compareTo(s) > 0));
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
