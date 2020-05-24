package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> firt = mockList("a", "b", "c", "d");
		List<String> seconder = mockList("c", "d", "g", "h");

		// hop
		List<String> mergedList = new ArrayList<>(firt);
		for (String string : seconder) {
			if (!mergedList.contains(string)) {
				mergedList.add(string);
			}
			// mergedList.addAll(seconder);
		}
		mergedList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n==========================");
		// giao
		List<String> junctionList = new ArrayList<>(firt);
		junctionList.retainAll(seconder);

		junctionList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n==========================");

		// hieu
		List<String> removeList = new ArrayList<>(firt);
		removeList.removeAll(seconder);

		removeList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n==========================");

	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);

		}
		return result;
	}
}
// Arraylist laf 1 danh sach chua phan tu lien ke nhau 
