package bt2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExpenseUtils {
	public static void expenseMore500(Map<String, Integer> expense) {
		Set<String> set = expense.keySet();
		for (String key : set) {
			if (expense.get(key) > 500000) {
				System.out.println(key + " :" + expense.get(key) + " VND");
			}
		}
	}

	public static void sortByKey(Map<String, Integer> expense) {
		Set<String> set = expense.keySet();
		List<String> lists = new ArrayList<>(set);
		lists.sort((s1, s2) -> s1.compareTo(s2));
		lists.forEach(list -> System.out.println(list + " :" + expense.get(list) + " VND"));
	}

	public static Map<String, Integer> sortByValue(Map<String, Integer> expense) {
		Map<String, Integer> sortMap = new LinkedHashMap<>();
		List<Entry<String, Integer>> sortlist = new ArrayList<>(expense.entrySet());
		sortlist.sort((s1, s2) -> s2.getValue().compareTo(s1.getValue()));
		for (Entry<String, Integer> entry : sortlist) {
			sortMap.put(entry.getKey(), entry.getValue());
		}
		return sortMap;

	}

}
