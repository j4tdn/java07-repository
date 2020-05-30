package generic.type;

import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();

		strings.add("A");
		strings.add("T");
		strings.add("C");
		strings.set(2, "K");
		System.out.println("size : " + strings.size());
		System.out.println("class: " + strings.getClass());
		System.out.println("Index 2:" + strings.get(2));

		// strings.addIndex(1, "Add Fake Item 1");
		// strings.remove(1);
		// strings.remove2("Fake Item 01");
		System.out.println("size : " + strings.size());
		// truyen ham vao trong ham

		strings.forEach(string -> {
			System.out.println(string);
		});
//---------------------------------------------------------------new Predicate<String>(){ham dk test()
		System.out.println("Generic than E :" + count(strings, s -> "B".compareTo(s) < 0));

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

	// forEach
	// add(i,e)
	// remove(i)
	// remove(E e)
}
