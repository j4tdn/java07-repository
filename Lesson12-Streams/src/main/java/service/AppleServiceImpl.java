package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Apple;
import dao.AppleDao;
import dao.AppleDaoImpl;
import predicate.Predicate;

public class AppleServiceImpl implements AppleService {
	private AppleDao dao = new AppleDaoImpl();

	@Override
	public List<Apple> getAll() {
		// load data from database => service => view
		return dao.getAll();
	}

	@Override
	public List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate) {
		if (inventory == null || inventory.isEmpty() || predicate == null) {
			return Collections.emptyList();
		}
		List<Apple> result = new ArrayList<>();
		for (Apple a : inventory) {
			if (predicate.test(a)) {
				result.add(a);
			}
		}
		return result;
	}
}