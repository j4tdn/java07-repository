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

		Store s1 = new Store("s1", "store 101", "A1");
		Store s2 = new Store("s2", "store 102", "A2");
		Store s3 = new Store("s3", "store 103", "A3");
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green", "Lao", 80, s1));
		apples.add(new Apple("red", "Lao", 60, s2));
		apples.add(new Apple("green", "VietNam", 120, s3));
		apples.add(new Apple("red", "VietNam", 240, s2));
		apples.add(new Apple("green", "Lao", 190, s1));
		return apples;

	}
}
