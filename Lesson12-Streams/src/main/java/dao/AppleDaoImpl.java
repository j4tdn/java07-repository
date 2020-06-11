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
		apples.add(new Apple("green", "VN", 120));
		apples.add(new Apple("green", "VN", 150));
		apples.add(new Apple("red", "VN", 160));
		apples.add(new Apple("green", "VN", 100));
		apples.add(new Apple("red", "Lao", 150));
		return apples;
	}
}