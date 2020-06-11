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
		apples.add(new Apple("green", 80, "Lao"));
		apples.add(new Apple("red", 180, "VN"));
		apples.add(new Apple("green", 120, "Thai"));
		apples.add(new Apple("red", 60, "Trung"));
		apples.add(new Apple("green", 100, "Han"));

		return apples;
	}

}
