package collections.map;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Ex01 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/**
		 * Breakfast 15 Cafe 17 Lunch 20 Football 120 Movie:140
		 */
		Map<String, Integer> myMap = new HashMap<>();
		myMap.put("Breakfast", 15);
		myMap.put("Football", 120);
		myMap.put("Cafe", 17);
		myMap.put("Lunch", 20);
		myMap.put("Football", 120);
		myMap.put("Movie", 140);
		System.out.println("size:" + myMap.size());
		System.out.println("Football: " + myMap.getOrDefault("Football", 20));
		System.out.println("====================================");
		myMap = sortByKey(myMap);
		loop(myMap);
		System.out.println("====================");
		myMap = sortByValue(myMap);
		loop(myMap);
		Map<String, Integer> sortedMap = myMap.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		loop(sortedMap);

		//////////
		@SuppressWarnings("rawtypes")
		Entry<String, Integer> firts = new SimpleEntry("Lunch", 20);
		@SuppressWarnings("rawtypes")
		Entry<String, Integer> second = new SimpleEntry("Cafe", 30);
		@SuppressWarnings("rawtypes")
		Entry<String, Integer> third = new SimpleEntry("Lunch", 40);

		BinaryOperator<Entry<String, Integer>> mergeFunction = (s1, s2) -> s2;
		// new BinaryOperator<Map.Entry<String, Integer>>() {
		// @Override
		// public Entry<String, Integer> apply(Entry<String, Integer> e1, Entry<String,
		// Integer> e2) {
		//
		// return Integer.compare(e1.getValue(), e2.getValue()) > 0 ? e1 : e2;
		// }
		// };

		Map<String, Integer> foodMap = Arrays.asList(firts, second, third).stream()
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (s1, s2) -> s2));
		loop(foodMap);

	}

	private static void loop(Map<String, Integer> myMap) {
		// // loop by key
		// for (String key : myMap.keySet()) {
		// System.out.println(key + " ===> " + myMap.get(key));
		// }
		// // loop by value
		// System.out.println("=======================");
		// for (Integer value : myMap.values()) {
		// System.out.println(value);
		// }
		System.out.println("=======================");
		// loop by entry
		for (Entry<String, Integer> entry : myMap.entrySet()) {
			System.out.println(entry);
		}

		//

	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> bugdet) {
		Map<String, Integer> sortMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
		sortMap.putAll(bugdet);
		return sortMap;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> bugdet) {
		List<Entry<String, Integer>> sortedList = new ArrayList<>(bugdet.entrySet());
		sortedList.sort(Entry.comparingByValue());

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>(sortedList.size());
		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
