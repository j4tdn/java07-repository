package collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<String> first = mockList("a","b","c");
		List<String> second  = mockList("a","b","e");
		
		List<String> mergeList = new ArrayList<String>(first);
		mergeList.addAll(second);
		System.out.println("=====merge List====");
		mergeList.forEach(list -> System.out.print(list + " "));
		
		List<String> interactionList = new ArrayList<String>(first);
		interactionList.retainAll(second);
		System.out.println("\n=====interaction List======");
		interactionList.forEach(list -> System.out.print(list + " "));
		
		List<String> removedList = new ArrayList<String>(first);
		removedList.removeAll(second);
		System.out.println("\n=====remove list======");
		removedList.forEach(list -> System.out.print(list + " "));
	}

	private static List<String> mockList(String ...strings ) {
		List<String> list  = new ArrayList<>();
		for (String string : strings) {
			list.add(string);
		}
		return list;
	}
}
