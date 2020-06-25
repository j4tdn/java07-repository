package dao;

import java.util.HashMap;
import java.util.Map;

import bt2.Expense;

public class ExpenseDaoImpl implements ExpenseDao<String, Integer> {
	@Override
	public Map<String, Integer> getAll() {

		return mockData();
	}

	private Map<String, Integer> mockData() {
		Map<String, Integer> expense = new HashMap<>();
		Expense expense2 = new Expense("Tiền Học", 4000000);
		Expense expense3 = new Expense("Tiền Trọ", 500000);
		Expense expense4 = new Expense("Tiền Ăn", 1500000);
		Expense expense5 = new Expense("Tiền Gym", 170000);
		Expense expense6 = new Expense("Tiền Giải Trí", 200000);
		expense.put(expense2.getExpenseInformation(), expense2.getAmount());
		expense.put(expense3.getExpenseInformation(), expense3.getAmount());
		expense.put(expense4.getExpenseInformation(), expense4.getAmount());
		expense.put(expense5.getExpenseInformation(), expense5.getAmount());
		expense.put(expense6.getExpenseInformation(), expense6.getAmount());
		return expense;
	}

}
