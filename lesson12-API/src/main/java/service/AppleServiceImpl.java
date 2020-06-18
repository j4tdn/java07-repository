package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import dao.AppleDao;
import dao.AppleDaoImpl;
import functions.StrategyPredicate;

public class AppleServiceImpl implements AppleService {
// load dâta from database => service => view 
	private AppleDao dao = new AppleDaoImpl();

	@Override
	public List<Apple> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate) {
		if(predicate == null || inventory == null || inventory.isEmpty()) {
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
