package service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import beans.Expense;
import dao.ExpenseDao;
import dao.ExpenseDaoImpl;
import predicate.Predicate;

public class ExpenseServiceImpl implements ExpenseService<String, Integer> {
	private ExpenseDao<String, Integer> dao = new ExpenseDaoImpl();

	@Override
	public Map<String, Integer> getAll() {
		return dao.getAll();
	}

	public Map<String, Integer> filter(Map<String, Integer> inventory, Predicate<Expense> predicate) {
		if (inventory == null || inventory.isEmpty() || predicate == null) {
			return Collections.emptyMap();
		}
		Map<String, Integer> result = new HashMap<>();
		Set<String> set = inventory.keySet();
		for (String key : set) {
			if (predicate.test(key)) {
				result.put(key, inventory.get(key));
			}
		}
		return result;
	}
}