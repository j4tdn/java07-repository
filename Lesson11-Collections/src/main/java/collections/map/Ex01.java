package collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ex01 {
	public static void main(String[] args) {
		Map<String, Integer> budget = new HashMap<>();

		budget.put("Breakfast", 20);
		budget.put("Coffee", 30);
		budget.put("Lunch", 20);
		budget.put("Football", 120);
		budget.put("Movie", 70);
		budget.putIfAbsent("Coffee", 50);

		System.out.println("size: " + budget.size());
		System.out.println("Budget Coffee: " + budget.get("Coffee"));
		System.out.println("Budget Football: " + budget.getOrDefault("Football", 20));

		budget = sortByValue(budget);

		loop(budget);
	}

	private static void loop(Map<String, Integer> budget) {
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println(key + "=> " + budget.get(key));
		}

		System.out.println("=========================");
		// loop by value
		for (Integer value : budget.values()) {
			System.out.println(value);
		}

		System.out.println("=========================");
		// loop by entry
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>((s1, s2) -> s2.compareTo(s1));
		sortedMap.putAll(budget);
		return sortedMap;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortedList = new LinkedList<>(budget.entrySet());

		sortedList.sort(Entry.comparingByValue());
		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
