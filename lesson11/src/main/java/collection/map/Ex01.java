package collection.map;

import java.util.ArrayList;
import java.util.Comparator;
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
		// breakfast :15
		// cafe :17
		// luch :20
		// football:120
		// movie :140
		Map<String, Integer> budget = new HashMap<>();
		budget.put("breakfast", 15);
		budget.put("cafe", 17);
		budget.put("luch", 20);
		budget.put("football", 120);
		budget.put("movie", 140);
		budget.putIfAbsent("cafe", 20);

		System.out.println("size :" + budget.size());

		System.out.println("budget cafe :" + budget.get("cafe"));
		System.out.println("budget football : " + budget.getOrDefault("football", 150));

		System.out.println("=======================");
		// loop by key
		budget=sortByKey(budget);
		loop(budget);
		budget=sortByKeyLon(budget);
		loop(budget);
		budget=sortByValue(budget);
		loop(budget);
		

	}
	@SuppressWarnings({ "unchecked", "unused" })
	private static Map<String, Integer> sortByValue(Map<String, Integer> budget){
		@SuppressWarnings("rawtypes")
		Map<String, Integer> sortedMap=new LinkedHashMap();
		@SuppressWarnings("rawtypes")
		List<Entry<String, Integer>> sortList = new LinkedList(budget.entrySet());
		sortList.sort(Entry.comparingByValue()); // tang dan
		
		
		//sortList.sort((e1,e2)-> e2.getValue().compareTo(e1.getValue()));
		for(Entry<String, Integer> entry : sortList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	private static void loop(Map<String, Integer> budget) {
		for (String key : budget.keySet()) {
			System.out.println(key + " " + budget.get(key));
		}
		System.out.println("=====================");
		// loop by value
		for (Integer value : budget.values()) {
			System.out.println(value);
		}
		System.out.println("=====================");
		// loop by entry

		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1,s2) -> s2.compareTo(s1));
		sortedMap.putAll(budget);
		return sortedMap;
	}
	private static Map<String, Integer> sortByKeyLon(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>(budget);
		return sortedMap;
	}

}
