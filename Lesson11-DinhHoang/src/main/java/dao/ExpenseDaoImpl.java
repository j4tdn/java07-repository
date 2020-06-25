package dao;

import java.util.HashMap;
import java.util.Map;

import beans.Expense;

public class ExpenseDaoImpl implements ExpenseDao<String, Integer> {
	@Override
	public Map<String, Integer> getAll() {
		return mockData();
	}

	private Map<String, Integer> mockData() {
		Map<String, Integer> expense = new HashMap<>();
		Expense expense1 = new Expense("Nhậu", 300);
		Expense expense2 = new Expense("Cafe", 250);
		Expense expense3 = new Expense("Tiền phòng", 700);
		Expense expense4 = new Expense("Học phí", 3000);
		Expense expense5 = new Expense("Tiền ăn", 1500);
		expense.put(expense1.getExpenditures(), expense1.getAmountOfMon());
		expense.put(expense2.getExpenditures(), expense2.getAmountOfMon());
		expense.put(expense3.getExpenditures(), expense3.getAmountOfMon());
		expense.put(expense4.getExpenditures(), expense4.getAmountOfMon());
		expense.put(expense5.getExpenditures(), expense5.getAmountOfMon());
		return expense;
	}
}