package dao;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExpenseDaoImpl implements ExpenseDao {

	@Override
	public Map<String, Integer> getAll() {
		return mock();

	}

	public static Map<String, Integer> mock() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		map.put("water", 100);
		map.put("electricity", 700);
		map.put("gas", 400);
		map.put("rent", 1500);
		map.put("food", 2000);
		return map;

	}

}
