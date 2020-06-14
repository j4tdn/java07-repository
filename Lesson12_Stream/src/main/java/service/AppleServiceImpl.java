package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import beans.Apple;
import dao.AppleDao;
import dao.AppleDaoImpl;
import function.StrategyPredicate;

public class AppleServiceImpl implements AppleService {

	private AppleDao dao = new AppleDaoImpl();

	@Override
	public List<Apple> getAll() {
		// load data from database=>service=>view
		return dao.getAll();
	}

	@Override
	public List<Apple> filter(List<Apple> inventory, StrategyPredicate<Apple> predicate) {

		if (predicate == null || inventory == null || inventory.isEmpty()) {
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
