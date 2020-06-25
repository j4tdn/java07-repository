package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;
import bean.Store;

public class AppleDaoImpl implements AppleDao {

	@Override
	public List<Apple> getAll() {

		return mockData();
	}

	private List<Apple> mockData() {
		Store s1 = new Store("s1", "Store 1", "A101");
		Store s2 = new Store("s2", "Store 2", "A102");
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green", "VN", 120, s1));
		apples.add(new Apple("green", "JP", 150, s1));
		apples.add(new Apple("red", "VN", 160, s2));
		apples.add(new Apple("green", "VN", 100, s2));
		apples.add(new Apple("green", "TL", 120, s1));
		apples.add(new Apple("red", "Lao", 150, s1));
		return apples;
	}

}
