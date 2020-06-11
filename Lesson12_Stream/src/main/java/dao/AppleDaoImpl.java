package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Apple;

public class AppleDaoImpl implements AppleDao {

	@Override
	public List<Apple> getAll() {
		return mockData();
	}

	private List<Apple> mockData() {
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green", "Lao", 80));
		apples.add(new Apple("red", "VN", 100));
		apples.add(new Apple("yellow", "Lao", 90));
		apples.add(new Apple("red", "China", 70));
		apples.add(new Apple("green", "VN", 120));
		return apples;

	}
}
