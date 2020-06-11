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
		apples.add(new Apple("green", 20, "Lao"));
		apples.add(new Apple("green", 200, "China"));
		apples.add(new Apple("red", 120, "Thai"));
		apples.add(new Apple("pink", 210, "Vietnam"));
		apples.add(new Apple("black", 21, "China"));
		return apples;
	}
}
