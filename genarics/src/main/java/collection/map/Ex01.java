package collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex01 {
	public static void main(String[] args) {
		/**
		 * 
		 */
		Map<String, Integer> budget = new HashMap<>();
		budget.put("Breakfast", 15);
		budget.put("Cafe", 17);
		budget.put("Lunch", 20);
		budget.put("Football", 120);
		budget.put("Movie", 140);
		budget.putIfAbsent("Cafe", 20);

		System.out.println("size: " + budget.size());
		System.out.println("Budget Cafe: " + budget.get("Cafe"));
		System.out.println("Football : " + budget.getOrDefault("Football", 20));

		System.out.println("===================================");

		budget = sortByKey(budget);
		loop(budget);
		
		sortByValue(budget);
		loop(budget);
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedmap = new TreeMap<>(budget);
		sortedmap.putAll(budget);
		return sortedmap;
	}

	private static void loop(Map<String, Integer> budget) {
		for (String key : budget.keySet()) {
			System.out.println(key + "=> " + budget.get(key));
		}
		System.out.println("===================================");

		for (Integer value : budget.values()) {
			System.out.println(value);
		}

		System.out.println("===================================");

		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}

	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		Map<String, Integer> sotedMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortedList = new LinkedList(budget.entrySet());
		sortedList.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		for (Entry<String, Integer> entry : sortedList) {
			sotedMap.put(entry.getKey(), entry.getValue());
		}
		return sotedMap;
	}
}
