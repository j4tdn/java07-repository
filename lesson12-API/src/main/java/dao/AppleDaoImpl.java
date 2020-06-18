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
	
	private List<Apple> mockData(){
		
//		Store s0 = new Store("S0","Store100","A0");
//		Store s1 = new Store("S1","Store101","A1");
//		Store s2 = new Store("S2","Store102","A2");
//		Store s3 = new Store("S3","Store103","A2");
//		
		List<Apple> apple = new ArrayList<>();
		apple.add(new Apple("green","Lao", 80));
		apple.add(new Apple("red","Lao", 160));
		apple.add(new Apple("green","VN", 120));
		apple.add(new Apple("red","VN", 180));
		return apple;
	}
}
