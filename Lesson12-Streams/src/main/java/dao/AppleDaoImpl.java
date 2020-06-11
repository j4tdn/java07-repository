package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;

public class AppleDaoImpl implements AppleDao {

	@Override
	public List<Apple> getAll() {

		return mockData();
	}

	private List<Apple> mockData() {
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green", "lao", 80));
		apples.add(new Apple("red", "lao", 160));
		apples.add(new Apple("red", "vietnam", 120));
		apples.add(new Apple("green", "vietnam", 240));
		apples.add(new Apple("green", "lao", 180));
		return apples;
	}

}
