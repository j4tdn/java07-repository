package date02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex05 {
	public static void main(String[] args) {
		Map<String, Integer> budget = new HashMap<>();

		budget.put("Breakfast", 20);
		budget.put("Coffee", 12);
		budget.put("Lucnh", 25);
		budget.put("Dinner", 20);
		budget.put("Hanging out", 600);

		loop(budget);
		System.out.println("==========Payment > 500==========");
		Map<String, Integer> result = budget.entrySet().stream().filter(b -> b.getValue() > 500)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		loop(result);

		System.out.println("==========Sort By Key In Ascending=========");
		budget = sortByKey(budget);
		loop(budget);

		System.out.println("==========Sort By Value In Descending=========");
		budget = sortByValue(budget);
		loop(budget);
	}

	private static void loop(Map<String, Integer> budget) {
		for (Entry<String, Integer> entry : budget.entrySet()) {
			System.out.println(entry);
		}
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> budget) {
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>();

		sortedMap.putAll(budget);
		return sortedMap;
	}

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
