package collections.map;

import static java.util.AbstractMap.SimpleEntry;
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
import java.util.stream.Collectors;

public class Ex01 {
	public static void main(String[] args) {
		/**
		 * breakfast:15 
		 * cafe:17 
		 * lunch:20 
		 * football 120 
		 * movie 140
		 */

		Map<String, Integer> budget = new HashMap<>();
		budget.put("breakfast", 15);
		budget.put("cafe", 17);
		budget.put("lunch", 20);
		budget.put("football", 120);
		budget.put("movie", 140);
		budget.putIfAbsent("cafe", 11);

		System.out.println("size :" + budget.size());
		System.out.println("Bugget cafe:" + budget.get("cafe"));
		System.out.println("football:" + budget.getOrDefault("football", 20));

		System.out.println("===================");
		// budget = sortByKey(budget);
		Map<String, Integer> sortedMap = budget.entrySet()
				.stream()
				.sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		Entry<String, Integer> first = new SimpleEntry<>("lunch",20);
		Entry<String, Integer> second = new SimpleEntry<>("coffee",30);
		Entry<String, Integer> third = new SimpleEntry<>("lunch",40);
		
		Map<String , Integer> foodMap = Arrays.asList(first,second,third).stream()
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		
		
		loop(foodMap);

	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortedList = new LinkedList<>(budget.entrySet());

		sortedList.sort(Entry.comparingByValue());

//		sortedList.sort(new Comparator<Entry<String, Integer>>() {
//			@Override
//			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
//				return e1.getValue().compareTo(e2.getValue());
//			}
//		});
		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
		sortedMap.putAll(budget);

		// Map<String, Integer> sortedMap = new TreeMap<>(budget);

		return sortedMap;
	}

	private static void loop(Map<String, Integer> budget) {
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println(key + "=>" + budget.get(key));
		}
		System.out.println("==============");
		// loop by value
		for (Integer value : budget.values()) {
			System.out.println(value);
		}
		System.out.println("==============");
		// loop by entry
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}
}
