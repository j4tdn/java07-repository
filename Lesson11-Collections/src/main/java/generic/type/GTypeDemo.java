package generic.type;

import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("Fake Item 01");
		strings.add("Fake Item 02");
		strings.add("Fake Item 03");
		System.out.println("Index 2: " + strings.get(2));
		strings.set(2, "new Item");
		System.out.println("Index 2: " + strings.get(2));
		System.out.println("size: " + strings.size());
		System.out.println("class: " + strings.getClass());
		/*
		 * for (int i = 0; i < strings.size(); i++) {
		 * System.out.print(strings.get(i)+", "); }
		 */
		strings.forEach(string -> {
			System.out.print(string + "  ");
		});
		
		System.out.println("\n========================");
		System.out.println("Geater than 'E:" + count(strings, s -> "B".compareTo(s) < 0));

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
