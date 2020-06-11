package collections.map;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex01 {
	public static void main(String[] args) {
		/**
		 * Breakfast: 15 Cafe: 17 Lunch: 20 Football: 120 Movie: 140
		 */

		Map<String, Integer> budget = new HashMap<>();
		budget.put("Lunch", 20);
		budget.put("Football", 120);
		budget.put("Breakfast", 15);
		budget.put("Cafe", 17);
		budget.put("Movie", 140);
		budget.putIfAbsent("Cafe", 20);

		System.out.println("size: " + budget.size());
		System.out.println("Budget cafe: " + budget.get("Cafe"));
		System.out.println("Football cafe: " + budget.getOrDefault("Football", 20));

		// budget = sortByValue(budget);
		// <1, 2>
		// <1, 3>

		Map<String, Integer> sortedMap = budget.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		Entry<String, Integer> first = new SimpleEntry<>("Lunch", 30);
		Entry<String, Integer> second = new SimpleEntry<>("Coffee", 30);
		Entry<String, Integer> third = new SimpleEntry<>("Lunch", 10);

	
		Map<String, Integer> foodMap = Arrays.asList(first, second, third).stream()
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2));

		loop(foodMap);
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
		sortedMap.putAll(budget);
		return sortedMap;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		// map => entrySet => linked list => sort => sorted list
		// => put into sorted map
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortedList = new LinkedList<>(budget.entrySet());
		sortedList.sort(Entry.comparingByValue());
		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	private static void loop(Map<String, Integer> budget) {
		System.out.println("=============================");
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println(key + " => " + budget.get(key));
		}

		System.out.println("=============================");
		// loop by value
		for (Integer value : budget.values()) {
			System.out.println(value);
		}

		System.out.println("=============================");
		// loop by entry
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}
}
