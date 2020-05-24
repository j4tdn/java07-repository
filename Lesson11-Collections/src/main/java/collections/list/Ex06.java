package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex06 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "v", "f");
		List<String> second = mockList("a", "c", "g");
		List<String> mergedList = new ArrayList<>();
		// Hợp
		mergedList.addAll(first);
		for (String string : second) {
			if (!mergedList.contains(string)) {
				mergedList.add(string);
			}
		}
		mergedList.forEach(string -> System.out.print(string + "\t"));
		// giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);
		System.out.println("\n================================================");
		junctionList.forEach(strings -> System.out.print(strings + "\t"));
		System.out.println("\n=====================================================");
		// Hiệu
		List<String> removeList = new ArrayList<>(first);
		removeList.removeAll(second);
		removeList.forEach(string -> System.out.print(string + "\t"));

	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
