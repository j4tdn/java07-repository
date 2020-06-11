package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Apple;

public class AppleDAOImpl implements AppleDao{

	public List<Apple> getAll() {
		return mockData();
	}
	
	private List<Apple> mockData(){
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("red", "China", 100));
		apples.add(new Apple("green", "VN", 120));
		apples.add(new Apple("yellow", "VN", 80));
		apples.add(new Apple("red", "VN", 150));
		apples.add(new Apple("green", "China", 100));
		return apples;
	}
}
