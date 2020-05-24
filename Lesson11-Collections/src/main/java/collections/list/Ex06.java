package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex06 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d");
		List<String> second = mockList("c", "f", "g", "h");

		// hop 2 list
		List<String> mergedList = new ArrayList<>(first);
		for (String string : second) {
			if (!mergedList.contains(string)) {
				mergedList.add(string);
			}
		}
		 //mergedList.addAll(second);
		mergedList.forEach(string -> System.out.print(string + " "));

		System.out.println("");
		// giao
		List<String> juntionList = new ArrayList<>(first);
		juntionList.retainAll(second);
		juntionList.forEach(string -> System.out.print(string + " "));

		System.out.println("");
		// hieu
		List<String> removeList = new ArrayList<>(first);
		removeList.removeAll(second);
		removeList.forEach(string -> System.out.print(string + " "));

		System.out.println("");

	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}

}
