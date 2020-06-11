package AppleDao;

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
		apples.add(new Apple("red", "Lao", 120));
		apples.add(new Apple("green", "Vn", 150));
		apples.add(new Apple("red", "Lao", 130));
		apples.add(new Apple("green", "Vn", 100));
		return apples;

	}
}
