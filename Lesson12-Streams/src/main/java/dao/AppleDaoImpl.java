package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Apple;

public class AppleDaoImpl implements AppleDao{

	@Override
	public List<Apple> getAll() {
		return mockData();
	}
	
	private List<Apple> mockData() {
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green", "Lao", 80));
		apples.add(new Apple("red", "Lao", 160));
		apples.add(new Apple("green", "VietNam", 120));
		apples.add(new Apple("green", "VietNam", 150));
		apples.add(new Apple("red", "Lao", 100));
		return apples;
	}
	
}
