package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import beans.Apple;
import dao.AppleDao;
import dao.AppleDaoImpl;
import function.StrategyPredicate;

public class AppleServiceImpl implements AppleService {
	private AppleDao dao = new AppleDaoImpl();

	@Override
	public List<Apple> getAll() {// phai la public vi luc runtime no moi vao dc
		// load data from database => service => view

		return dao.getAll();
	}

	@Override
	public List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate) {
		if (inventory == null || inventory.isEmpty()) {
			return Collections.emptyList();
		}
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
}