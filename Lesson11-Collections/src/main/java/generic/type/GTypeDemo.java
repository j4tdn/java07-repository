package generic.type;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();
		strings.add("A");
		strings.add("D");
		strings.add("F");

		System.out.println("size: " + strings.size());
		strings.set(2, "K");
		System.out.println("Index 2: " + strings.get(2));
		System.out.println("class: " + strings.getClass());

		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		/***
		 * List<String> list = new LinkedList<>(); list.forEach(new Consumer<String>() {
		 * 
		 * @Override public void accept(String item) { System.out.println(item); } });
		 */
		System.out.println("====================");
		strings.forEach(string -> {
			System.out.println(string);
		});
		System.out.println("=================");
//		System.out.println("Greater than 'E': " + count(strings, new Predicate<String>() {
//
//			@Override
//			public boolean test(String t) {
//				return t.compareTo("B") > 0;
//			}
//		}));
		System.out.println("Greater than 'E': " + count(strings, string -> "A".equals(string)));
	}

	private static <E> int count(FakeList<E> list, Predicate<E> predicate) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).compareTo(element) > 0) {
//				count ++;
//			}
			if(predicate.test(list.get(i))) {
				count ++;
			}
		}
		return count;
	}
}
