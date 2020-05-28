package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "d");
		List<String> second = mockList("c", "d", "g", "h");

		// hợp

		// List<String> mergeList=new ArrayList<>();
		// mergeList.addAll(first);

		List<String> mergeList = new ArrayList<>(first);
		//mergeList.addAll(second);
		//hop nang cao
		for(String string:second) {
			if(!mergeList.contains(string)) {
				mergeList.add(string);
			}
		}
		
		
		mergeList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n=======================");
		
		// giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);
		junctionList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n=======================");
		
		// hieu
		List<String> removeList = new ArrayList<>(first);
		removeList.removeAll(second);
		removeList.forEach(string -> System.out.print(string + " "));
		
		System.out.println("\n=======================");
	}

	private static List<String> mockList(String... strings) {

		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
