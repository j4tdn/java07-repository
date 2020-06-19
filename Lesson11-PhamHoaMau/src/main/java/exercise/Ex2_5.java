package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex2_5 {
	public static void main(String[] args) {
		Map<String, Double> dailyExpenses = new HashMap<>();
		dailyExpenses = createMap();
		showMap(dailyExpenses);
		expenseGreaterValue(dailyExpenses, 15.0);
		dailyExpenses = sortASCByKey(dailyExpenses);
		showMap(dailyExpenses);
		dailyExpenses = sortDECSByValue(dailyExpenses);
		showMap(dailyExpenses);
	}

	private static Map<String, Double> sortDECSByValue(Map<String, Double> dailyExpenses) {
		System.out.println("==== Sorted DESC By Value ====");
		Map<String, Double> sortedMap = new LinkedHashMap<>();
		List<Entry<String, Double>> sortedList = new ArrayList<>(dailyExpenses.entrySet());
		sortedList.sort(Entry.comparingByValue(Comparator.reverseOrder()));
		for (Entry<String, Double> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	private static Map<String, Double> sortASCByKey(Map<String, Double> dailyExpenses) {
		System.out.println("===== Sorted ASC By Key =====");
		Map<String, Double> sortedMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
		sortedMap.putAll(dailyExpenses);
		return sortedMap;
	}

	private static void expenseGreaterValue(Map<String, Double> dailyExpenses, double value) {
		System.out.println("==== Show Expense Greater " + value + " =====");
		for (Map.Entry<String, Double> item : dailyExpenses.entrySet()) {
			if (item.getValue() > value) {
				System.out.println(item.getKey() + "\t" + item.getValue());
			}
		}
	}

	private static void showMap(Map<String, Double> dailyExpenses) {
		for (String key : dailyExpenses.keySet()) {
			System.out.println(key + "\t" + dailyExpenses.get(key));
		}
	}

	private static Map<String, Double> createMap() {
		System.out.println("=== Create Daily Expenses ====");
		Map<String, Double> dailyExpenses = new LinkedHashMap<>();
		dailyExpenses.put("Breakfast", 15.0);
		dailyExpenses.put("Coffee  ", 10.0);
		dailyExpenses.put("Lunch    ", 20.0);
		dailyExpenses.put("Dinner  ", 20.0);
		dailyExpenses.put("Drink Beer", 100.0);
		return dailyExpenses;
	}
}
