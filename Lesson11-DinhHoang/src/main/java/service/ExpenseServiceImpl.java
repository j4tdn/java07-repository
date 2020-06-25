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
}