package collection.map;

import static java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex01 {
	public static void main(String[] args) {
		// Ko theo thứ tự đưa vào
		Map<String, Integer> budget = new HashMap<>();

		// Theo thứ tự đưa vào
		// Map<String, Integer> budget = new LinkedHashMap();

		// Sắp xếp theo key
		// Map<String, Integer> budget = new TreeMap();

		budget.put("Breakfast", 15);
		budget.put("Cafe", 17);
		budget.put("Movie", 140);
		budget.put("Lunch", 20);
		budget.put("Football", 120);

		// budget.putIfAbsent("Cafe", 20);

		System.out.println("size: " + budget.size());
		System.out.println("Cafe : " + budget.get("Cafe"));
		System.out.println("Budget footbal: " + budget.getOrDefault("Football", 20));
//		budget = sortByKey(budget);
//		loop(budget);

		// budget = sortByKey2(budget);
		// loop(budget);

//		budget = sortByValue(budget);
		// loop(budget);
		Map<String, Integer> sortedMap = budget.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		Entry<String, Integer> first = new SimpleEntry<>("Lunch", 20);
		Entry<String, Integer> second = new SimpleEntry<>("Coffee", 30);
		Entry<String, Integer> third = new SimpleEntry<>("Lunch", 40);

		BinaryOperator<Entry<String, Integer>> mergeFuntion = (e1, e2) -> e2;

		Map<String, Integer> foodMap = Arrays.asList(first, second, third).stream()
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue,(e1, e2) -> e2));
		loop(foodMap);
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>(budget);
		return sortedMap;
	}

	private static Map<String, Integer> sortByKey2(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
		sortedMap.putAll(budget);
		return sortedMap;
	}

//
	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		// Set<Entry<String, Integer>> entrySet = budget.entrySet();
		Map<String, Integer> sortedMap = new LinkedHashMap<>();

		List<Entry<String, Integer>> sortedList = new ArrayList<>(budget.entrySet());
		// sortedList.sort(Entry.comparingByValue());
		sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
		/*
		 * sortedList.sort(new Comparator<Entry<String, Integer>>() {
		 * 
		 * @Override public int compare(Entry<String, Integer> e1, Entry<String,
		 * Integer> e2) { return e1.getValue().compareTo(e2.getValue()); } });
		 */

	}

	private static void loop(Map<String, Integer> budget) {
		System.out.println("==============================");
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println(key + " => " + budget.get(key));
		}

		System.out.println("==============================");
		// loop by value
		for (Integer value : budget.values()) {
			System.out.println(value);
		}

		System.out.println("==============================");
		// loop by entry
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}

	}

}
