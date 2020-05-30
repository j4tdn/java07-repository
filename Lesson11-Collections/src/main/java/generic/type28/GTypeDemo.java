package generic.type28;

import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("A");
		strings.add("D");
		strings.add("K");

		System.out.println(strings.size());
		System.out.println("index 2 " + strings.get(2));
		strings.set(2, "j");
		System.out.println(strings.getClass());

		System.out.println("==========================");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i) + " ");
		}

		System.out.println("==========================");

		System.out.println("==========================");
		strings.forEach1(string -> {
			System.out.println(string + " ");
		});
		System.out.println("==========================");
		System.out.println("Greater than 'E':" + count(strings, s ->"B".compareTo(s) < 0));

	}// string

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
