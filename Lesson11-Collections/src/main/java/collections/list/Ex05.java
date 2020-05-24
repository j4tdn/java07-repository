package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d", "e");
		List<String> second = mockList("g", "k", "a", "b", "z");

		// hop
		List<String> mergedList = new ArrayList<>(first);
		//mergedList.addAll(second);

		for(String string : second) {
			if(!first.contains(string)) {
				mergedList.add(string);
			}
		}
		mergedList.forEach(ele -> System.out.print(ele + "  "));
		System.out.println("\n===============================");
		
		
		// giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);

		junctionList.forEach(ele -> System.out.print(ele + "  "));
		System.out.println("\n===============================");
		
		// hieu
		List<String> removedList = new ArrayList<>(first);
		removedList.removeAll(second);

		removedList.forEach(ele -> System.out.print(ele + "  "));
		System.out.println("\n===============================");
	}

	private static List<String> mockList(String... strings) {
		List<String> results = new ArrayList<>();
		for (String s : strings) {
			results.add(s);
		}

		return results;
	}

}
