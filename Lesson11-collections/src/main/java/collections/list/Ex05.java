package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d");
		List<String> second = mockList("e", "f", "g", "h");

		// hop
		List<String> mergeList = new ArrayList<>(first);
		mergeList.addAll(second);

		mergeList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n=================================");

		List<String> juncionList = new ArrayList<>(first);
		juncionList.retainAll(second);

		juncionList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n=================================");
	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
