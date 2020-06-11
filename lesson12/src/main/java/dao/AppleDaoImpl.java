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
		apples.add(new Apple("red", "Lao", 60));
		apples.add(new Apple("green", "VietNam", 120));
		apples.add(new Apple("red", "VietNam", 240));
		apples.add(new Apple("green", "Lao", 90));
		return apples;

	}
}
