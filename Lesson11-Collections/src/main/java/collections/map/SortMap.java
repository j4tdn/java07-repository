package collections.map;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortMap {
	public static void main(String[] args) {
		Map<String, Integer> budget = new HashMap<>();
		budget.put("Breakfast", 15);
		budget.put("Coffee", 17);
		budget.put("Lunch", 20);
		budget.put("Football", 150);
		// budget.putIfAbsent("Coffee", 150);

		System.out.println("Size: " + budget.size());
		System.out.println("Budget Coffee: " + budget.get("Coffee"));

		budget = sortByKey(budget);
		System.out.println("Sort By Key");
		loop(budget);
		budget = sortByValue(budget);
		System.out.println("Sort By Value");
		loop(budget);

	}

	private static  Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortedList = new ArrayList<>(budget.entrySet());
		//sortedList.sort((o1,o2) -> o2.getValue().compareTo(o1.getValue()));
		sortedList.sort(Entry.comparingByValue());
		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
		sortedMap.putAll(budget);
		return sortedMap;
	}

	private static void loop(Map<String, Integer> budget) {
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println("Key: " + key + "\t\tValue:" + budget.get(key));
		}
		/***
		 * System.out.println("======================="); //loop by value for (Integer
		 * value : budget.values()) { System.out.println("Value: " + value); }
		 * System.out.println("======================="); //loop by entry for
		 * (Map.Entry<String, Integer> item : budget.entrySet()) {
		 * System.out.println(item); }
		 */
	}
}
