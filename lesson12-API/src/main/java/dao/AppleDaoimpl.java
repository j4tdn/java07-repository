package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Apple;

public class AppleDaoimpl  implements AppleDao{

	@Override
	public List<Apple> getAll() {
		return mockData();
	}
	
	private List<Apple> mockData(){
		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple("green","Lao",80));
		apples.add(new Apple("red","VietNam",160));
		apples.add(new Apple("Blue","Lao",180));
		apples.add(new Apple("red","Thai",70));
		apples.add(new Apple("green","Lao",240));
		return apples;
	}
}
