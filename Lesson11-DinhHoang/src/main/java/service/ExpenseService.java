package service;

import java.util.Map;

public interface ExpenseService<T, R> {
	Map<T, R> getAll();
}