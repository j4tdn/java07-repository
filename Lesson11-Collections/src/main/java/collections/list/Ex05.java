package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a", "b", "c", "e", "h");
		List<String> second = mockList("g", "e", "f", "m", "n");
//		List<String> mergeList = new ArrayList<>();
		//Hop
		List<String> mergeList = new ArrayList<>(first);
//		mergeList.addAll(first);
//		mergeList.addAll(second);
		for (String string : second) {
			if (!mergeList.contains(string)) {
				mergeList.add(string);
			}
		}
		mergeList.forEach(string -> System.out.print(string + " "));
		System.out.println("\n---------------------------");
		//Giao
		List<String> junctionList = new ArrayList<>(first);
		junctionList.retainAll(second);
		junctionList.forEach(string -> System.out.print(string + " "));
		//Hieu
		System.out.println("\n---------------------------");
		List<String> removeList = new ArrayList<>(first);
		removeList.removeAll(second);
		removeList.forEach(string -> System.out.print(string + " "));
	}
	
	private static List<String> mockList(String ...strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
