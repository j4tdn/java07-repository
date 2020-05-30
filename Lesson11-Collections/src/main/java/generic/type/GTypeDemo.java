package generic.type;

import java.util.function.Predicate;

import generic.classs.FakeList;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("a");
		strings.add("b");
		strings.add("d");
		strings.add("e");
//		System.out.println("size: " + strings.size());
//		strings.set(2, "newItem");
//		System.out.println("Index 2: " + strings.get(2));
//		System.out.println("class: " + strings.getClass());

//		for (int i = 0; i < strings.size(); i++) {
//			System.out.print(strings.get(i) + " ");
//		}

//		strings.add(2, "newItem2");
//		strings.remove(2);
//		strings.remove("newItem");
//		strings.forEach(s -> System.out.println(s + " "));

		System.out.println("Greater than E: " + count(strings, s -> "c".compareTo(s) > 0));
	}

	private static <E> int count(FakeList<E> list, Predicate<E> predicate) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (predicate.test(list.get(i))) {
				count++;
			}
		}
		return count;
	}
}
