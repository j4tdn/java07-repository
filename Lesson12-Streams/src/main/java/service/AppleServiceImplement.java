package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.Apple;
import dao.AppleDAOImpl;
import dao.AppleDao;
import function.StrategyPredicate;

public class AppleServiceImplement implements AppleService{
	
	private AppleDao dao = new AppleDAOImpl();
	
	@Override
	public List<Apple> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Apple> filter(List<Apple> inventory, StrategyPredicate<Apple> predicate) {
		if(predicate == null || inventory == null || inventory.isEmpty()) {
			return Collections.emptyList();
		}
		List<Apple> results = new ArrayList<>();
		for (Apple apple : inventory) {
			if(predicate.test(apple)) {
				results.add(apple);
			}
		}
		return results;
	}
	
}
