package generic.type;

import java.util.function.Predicate;

public class GTypeDemo {

	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();

		strings.add("a");
		strings.add("b");
		strings.add("c");
		System.out.println("size: " + strings.size());
		strings.set(2, "real item");
		System.out.println("index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());
		System.out.println("==============================");
		System.out.println("remove " + strings.remove("a"));
		strings.add(2, "v");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		
		System.out.println("==============================");
		System.out.println("Greater than 'E': " + count(strings, s -> "b".compareTo(s) < 0));
	}

	private static <E> int count(FakeList<E> list, Predicate<E> pre) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if(pre.test(list.get(i))) {
				count++;
			}
		}
		return count;
	}
}
