package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d", "g");
		List<String> second = mockList("e", "f", "g", "h", "a");
		List<String> mergedList = new ArrayList<>(first);
//		mergeList.addAll(first);
		for (String string : second) {
			if (!(mergedList.contains(string))) {
				mergedList.add(string);
			}
		}
		mergedList.forEach(s -> System.out.print(s + " "));
		System.out.println("\n===============");

		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);
		junctionList.forEach(s -> System.out.print(s + " "));
		System.out.println("\n===============");
	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}