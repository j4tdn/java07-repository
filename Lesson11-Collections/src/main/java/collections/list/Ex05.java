package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d");
		List<String> second = mockList("c", "d", "e", "f");

		// hop
		/*
		 * List<String> mergeList = new ArrayList<>(first); mergeList.addAll(second);
		 * mergeList.forEach(str -> System.out.print(str + "  "));
		 */

		// hop nang cao
		List<String> mergeList = new ArrayList<>(first);
		for (String str : second) {
			if (!mergeList.contains(str)) {
				mergeList.add(str);
			}
		}
		mergeList.forEach(str -> System.out.print(str + "  "));

		System.out.println();

		// giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);
		junctionList.forEach(str -> System.out.print(str + "  "));

		System.out.println();

		// hieu
		List<String> removedList = new ArrayList<>(first);
		removedList.removeAll(second);
		removedList.forEach(str -> System.out.print(str + "  "));

	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
