package generic.type;

import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add("e");
		strings.add("f");
		strings.add("g");

//		System.out.println("size: " + strings.size());
//		strings.set(2, "DODODO");
//		System.out.println("Index 2: " + strings.get(2));
//		System.out.println("class: " + strings.getClass());
//
//		strings.add(0, "Long");

//		strings.remove(0);
//		strings.remove(2);

		// strings.remove(0);
		// strings.remove("a");

//		for (int i = 0; i < strings.size(); i++) {
//			System.out.println(strings.get(i));
//		}

		strings.forEach((string) -> System.out.println(string));
		System.out.println("=================");

		System.out.println("Greater than c: " + count(strings, s -> "a".equals(s)));
	}

	private static <E> int count(FakeList<E> list, Predicate<E> pre) {
		int count = 0;

		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).compareTo(e) > 0) {
//				count++;
//			}
			if (pre.test(list.get(i))) {
				count++;
			}
		}
		return count;
	}
}
