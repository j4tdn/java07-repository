package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d");
		List<String> second = mockList("e", "f", "c", "h");

		// Hop
		List<String> mergedList = new ArrayList<>(first);
		for (String string : second) {
			if (!mergedList.contains(string)) {
				mergedList.add(string);
			}
		}
		// mergedList.addAll(second);

		mergedList.forEach(string -> System.out.print(string + " "));

		System.out.println("\n========================");
		// Giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);

		junctionList.forEach(string -> System.out.print(string + " "));

		System.out.println("\n========================");
		// Hieu
		List<String> removeList = new ArrayList<>(first);
		removeList.removeAll(second);

		removeList.forEach(string -> System.out.print(string + " "));
	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
