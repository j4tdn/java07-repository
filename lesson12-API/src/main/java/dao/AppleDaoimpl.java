package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Apple;

public class AppleDaoImpl implements AppleDao {

	@Override
	public List<Apple> getAll() {
		return mockData();
	}
	
	private List<Apple> mockData(){
		List<Apple> apple = new ArrayList<>();
		apple.add(new Apple("green","Lao", 80));
		apple.add(new Apple("red","Lao", 160));
		apple.add(new Apple("green","VN", 120));
		apple.add(new Apple("red","VN", 180));
		return apple;
	}
}
