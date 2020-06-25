package date02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Predicate;

import dao.ExpenseDao;
import dao.ExpenseDaoImpl;

public class Ex05 {
	private static ExpenseDao dao = new ExpenseDaoImpl();

	public static void main(String[] args) {
		Map<String, Integer> expense = dao.getAll();
		System.out.println("Chi tieu tren 500");
		Map<String, Integer> expenseThan500 = expenseThan500(expense);
		show(expenseThan500);
		System.out.println("================");
		System.out.println("Tang dan theo key");
		Map<String, Integer> asc = AscKey(expense);
		show(asc);
		System.out.println("================");
		System.out.println("giam dan theo value");
		Map<String, Integer> desc = DescValue(expense);
		show(desc);
	}

	public static void show(Map<String, Integer> expense) {
		for (Entry<String, Integer> entry : expense.entrySet()) {
			System.out.println(entry);
		}

	}

	public static Map<String, Integer> expenseThan500(Map<String, Integer> expense) {
		Map<String, Integer> expense500 = new TreeMap<String, Integer>();

		for (Entry<String, Integer> entry : expense.entrySet()) {
			if (entry.getValue() > 500) {
				expense500.put(entry.getKey(), entry.getValue());
			}
		}

		return expense500;

	}

	public static Map<String, Integer> AscKey(Map<String, Integer> expense) {
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		List<Entry<String, Integer>> list = new ArrayList<>(expense.entrySet());

		list.sort(Comparator.comparing(Entry::getKey));
		for (Entry<String, Integer> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;

	}

	public static Map<String, Integer> DescValue(Map<String, Integer> expense) {
		Map<String, Integer> result = new LinkedHashMap<String, Integer>();
		List<Entry<String, Integer>> list = new ArrayList<>(expense.entrySet());

		list.sort(Comparator.comparing(Entry::getValue));
		for (int i = list.size() - 1; i >= 0; i--) {

			Entry<String, Integer> entry = list.get(i);
			result.put(entry.getKey(), entry.getValue());
		}
		return result;

	}
}
