package generics.type;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GTypeDemo {
	public static void main(String[] args) {
		FakeList<String> strings = new FakeList<>();

		strings.add("A");
		strings.add("D");
		strings.add("S");
		// strings.add("d");
		System.out.println("\n==========");
		// strings.remove("a");
		System.out.println("\n=============");
		System.out.println("size: " + strings.size());
		System.out.println(strings.getClass());

		System.out.println("============================");
		strings.forEach(string -> {
			System.out.println(string);
		});
		System.out.println("Greater than 'E': " + count(strings, s -> "A".equals(s)));

		System.out.println("==========================");
		List<String> s = new ArrayList<>();
		s.stream().count();
	}

	// điều kiện bên ngoài truyền vào
	private static <T> int count(FakeList<T> list, Predicate<T> pre) {
		int count = 0;
		for (int index = 0; index < list.size(); index++) {

			// if (list.get(index).compareTo(elem) > 0) {
			// count++;
			//
			// }
			if (pre.test(list.get(index))) {
				count++;
			}
		}

		return count;
	}
}