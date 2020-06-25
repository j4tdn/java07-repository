package service;

import java.util.Map;

import dao.ExpenseDao;
import dao.ExpenseDaoImpl;

public class ExpenseServiceImpl implements ExpenseService<String, Integer> {
	private ExpenseDao<String, Integer> dao = new ExpenseDaoImpl();

	@Override
	public Map<String, Integer> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
