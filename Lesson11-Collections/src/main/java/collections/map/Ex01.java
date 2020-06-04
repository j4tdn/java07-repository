package collections.map;

import static java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class Ex01 {
	public static void main(String[] args) {
		Map<String, Integer> budget = new HashMap<>();
		// HashMap: ko dam bao thu tu dua vao ma sort theo ma bam
		// LinkedMap: theo thu tu dua vao
		// TreeMap: sap xep theo key tang dan
		budget.put("Breakfast", 15);
		budget.put("Cafe", 20);
		budget.put("Lunch", 30);
		budget.put("Football", 150);
		budget.put("Movie", 155);
		budget.putIfAbsent("Cafe", 17);

		System.out.println("Size: " + budget.size());
		System.out.println("Cafe: " + budget.get("Cafe"));
		System.out.println("Football: " + budget.getOrDefault("Fo0tball", 160));

		budget = sortByKey(budget);
		// loop(budget);

		// budget = sortByValue(budget);
		Map<String, Integer> sortedMap = budget.entrySet()
				.stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		// loop(sortedMap);

		Entry<String, Integer> first = new SimpleEntry<>("Lunch", 30);
		Entry<String, Integer> second = new SimpleEntry<>("Coffee", 30);
		Entry<String, Integer> third = new SimpleEntry<>("Coffee", 40);

		Map<String, Integer> foodMap = Arrays.asList(first, second, third).stream()
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2));
		loop(foodMap);
	}

	private static void loop(Map<String, Integer> budget) {
		System.out.println("=============================");
		// loop by key
		for (String key : budget.keySet()) {
			System.out.println(key + " => " + budget.get(key));
		}

		System.out.println("=============================");
		// loop by value
		for (Integer val : budget.values()) {
			System.out.println(val);
		}

		System.out.println("=============================");
		// loop by entry
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		// Map<String, Integer> sortedMap= new TreeMap<>(budget); auto tang dan
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s1.compareTo(s2));
		sortedMap.putAll(budget);
		return sortedMap;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortedList = new ArrayList<>(budget.entrySet());
		// sortedList.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		sortedList.sort(Entry.comparingByValue());
		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
