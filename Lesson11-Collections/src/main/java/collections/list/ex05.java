package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d");
		List<String> second = mockList("c", "d", "e", "f");

		// Hop
		List<String> mergedList = new ArrayList<>(first);
		// mergedList.addAll(first);
		for (String string2 : second) {
			if (!mergedList.contains(string2) ) {
				mergedList.add(string2);
			}
		}
		// mergedList.addAll(second);

		mergedList.forEach(string -> System.out.printf(string + " "));
		System.out.println("\n================");

		// Giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);

		junctionList.forEach(string -> System.out.printf(string + " "));
		System.out.println("\n================");

		// Hieu
		List<String> removedList = new ArrayList<>(first);
		removedList.removeAll(second);

		removedList.forEach(string -> System.out.printf(string + " "));
		System.out.println("\n================");
		
		
	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<String>();
		for (String string : strings) {
			result.add(string);
		}
		return result;
	}
}
