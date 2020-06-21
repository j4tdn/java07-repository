package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Apple;
import beans.Store;

public class AppleDaoImpl implements AppleDao {

	@Override
	public List<Apple> getAll() {
		return mockData();
	}

	private List<Apple> mockData() {
		List<Apple> apples = new ArrayList<>();
		Store s1 = new Store("s1", "Store 101", "A1");
		Store s2 = new Store("s2", "Store 102", "A2");
		Store s3 = new Store("s3", "Store 103", "A3");

		apples.add(new Apple("green", "Lao", 180, s1));
		apples.add(new Apple("red", "VN", 100, s2));
		apples.add(new Apple("yellow", "Lao", 190, s1));
		apples.add(new Apple("red", "China", 170, s3));
		apples.add(new Apple("green", "VN", 120, s2));
		apples.add(new Apple("green", "Indo", 180, s1));
		return apples;

	}
}
