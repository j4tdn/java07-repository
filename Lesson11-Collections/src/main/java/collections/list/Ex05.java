package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d");
		List<String> second = mockList("e", "f", "c", "h");
		// hop
		List<String> mergeList = new ArrayList<>(first);
		for(String string: second) {
			if(!mergeList.contains(string)) {
				mergeList.add(string);
			}
		}
		//mergeList.addAll(second);
		// giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);
		// hieu
		List<String> removedList = new ArrayList<>(first);
		removedList.removeAll(second);

		mergeList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n===============");
		junctionList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n===============");
		removedList.forEach(string -> System.out.print(string + " "));
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
