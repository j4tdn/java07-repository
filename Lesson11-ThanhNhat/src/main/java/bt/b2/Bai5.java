package bt.b2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Bai5 {
	private static Integer VALUE = 500;

	public static void main(String[] args) {
		Map<String, Integer> budget = new HashMap<>();

		budget.put("Breakfast", 150);
		budget.put("Cafe", 200);
		budget.put("Lunch", 300);
		budget.put("Football", 550);
		budget.put("Movie", 650);
		budget.put("Shopping", 1650);

		System.out.println("Thong tin cac khoan chi lon hon 500 ngin VND:");
		filter(budget, VALUE);
		System.out.println("Sap xep cac khoan chi theo thu tu tang dan cua cac key:");
		budget = sortByKey(budget);
		show(budget);
		System.out.println("Sap xep cac khoan chi theo thu tu giam dan boi so tien:");
		budget = sortByValue(budget);
		show(budget);
	}

	private static void show(Map<String, Integer> budget) {
		for (String key : budget.keySet()) {
			System.out.println(key + " => " + budget.get(key));
		}
	}

	private static void filter(Map<String, Integer> budget, Integer value) {
		for (Entry<String, Integer> entry : budget.entrySet()) {
			if (entry.getValue() > value) {
				System.out.println(entry);
			}
		}
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<>((s1, s2) -> s1.compareTo(s2));
		sortedMap.putAll(budget);
		return sortedMap;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortedList = new ArrayList<>(budget.entrySet());
		sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
		for (Entry<String, Integer> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
