package collections.map;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Ex01 {

	public static void main(String[] args) {
		/**
		 * Breakfast: 15 Cafe: 17 Lunch: 20 Football: 120 Movie: 140
		 */

		Map<String, Integer> budget = new HashMap<>();
		budget.put("Breakfast", 15);
		budget.put("Cafe", 17);
		budget.put("Lunch", 20);
		budget.put("Football", 120);
		budget.put("Movie", 140);
		budget.putIfAbsent("Cafe", 20);

		System.out.println("size: " + budget.size());
		System.out.println("Budget cafe: " + budget.get("Cafe"));
		System.out.println("Budget football: " + budget.getOrDefault("Football", 20));
		System.out.println("=========================");

		// budget = sortByValue(budget);
		Map<String, Integer> sortedMap = budget.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		Entry<String, Integer> e1 = new SimpleEntry("Lucnh", 20);
		Entry<String, Integer> e2 = new SimpleEntry("Dinner", 30);
		Entry<String, Integer> e3 = new SimpleEntry("Football", 10);
		Entry<String, Integer> e4 = new SimpleEntry("Coffee", 50);
		Entry<String, Integer> e5 = new SimpleEntry("Movie", 40);
		
		Map<String, Integer> footMap =  Arrays.asList(e1, e2, e3, e4, e5)
				.stream()
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (s1, s2) -> s2, LinkedHashMap::new));
		
		loop(footMap);
	}

	private static void loop(Map<String, Integer> budget) {
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println(key + " => " + budget.get(key));
		}

		// loop by value
		System.out.println("=========================");
		for (Integer value : budget.values()) {
			System.out.println(value);
		}

		// loop by entry
		System.out.println("=========================");
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
		sortedMap.putAll(budget);
		return sortedMap;
	}

	@SuppressWarnings("unused")
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
