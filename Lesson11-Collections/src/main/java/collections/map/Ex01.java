package collections.map;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex01 {
	/**
	 * breakfast 15k cafe 17k lunch 20k football 120k movie 140k
	 */
	public static void main(String[] args) {
		Map<String, Integer> budget = new HashMap<>();
		budget.put("breakfast", 15);
		budget.put("cafe", 17);
		budget.put("football", 120);
		budget.put("movie", 140);
		budget.putIfAbsent("cafe", 15);
		budget.put("lunch", 20);

		System.out.println("size: " + budget.size());
		System.out.println("Buget cafe: " + budget.get("cafe"));

		budget = sortByKey(budget);
		loop(budget);
		
		sortByValue(budget);
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1)); // so sánh s1 vs s2
		sortedMap.putAll(budget);
		// budget = sortedMap;
		return sortedMap;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		// map => entrylist => linkedList => sort => sortedlist => put into soreted map
		Map<String, Integer> sortMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortList = new ArrayList<>(budget.entrySet());
		sortList.sort(Entry.comparingByValue());
		for (Entry<String, Integer> entry : sortList) {
			sortMap.put(entry.getKey(), entry.getValue());

		}
		return sortMap;
	}

	private static void loop(Map<String, Integer> budget) {
		System.out.println("-----------------------------");
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println(key + " " + budget.get(key));
		}
		System.out.println("-----------------------------");
		// loop by value
		for (Integer value : budget.values()) {
			System.out.println(value);
		}

		System.out.println("-----------------------------");
		// loop by entry
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}
}
