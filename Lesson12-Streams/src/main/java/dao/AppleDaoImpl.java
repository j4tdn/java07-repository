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
		Store s1 = new Store("s1", "store 101","A1");
		Store s2 = new Store("s2", "store 102","A2"); 
		Store s3 = new Store("s3", "store 103","A3"); 
		
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green", "lao", 80,s1));
		apples.add(new Apple("red", "lao", 160,s3));
		apples.add(new Apple("red", "vietnam", 120,s3));
		apples.add(new Apple("green", "vietnam", 240,s2));
		apples.add(new Apple("green", "lao", 180,s1));
		return apples;
	}

}
