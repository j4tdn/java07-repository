package dao;

import java.util.Map;

public interface ExpenseDao<T, R> {
	Map<T, R> getAll();
}