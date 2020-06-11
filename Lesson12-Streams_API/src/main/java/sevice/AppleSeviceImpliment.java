package sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import AppleDao.AppleDao;
import AppleDao.AppleDaoImpl;
import beans.Apple;

public class AppleSeviceImpliment implements AppleSevice {
	private AppleDao dao = new AppleDaoImpl();
	
	@Override
	public List<Apple> getAll() {
		return dao.getAll();
	};

	@Override
	public List<Apple> filter(List<Apple> inventory,predicate) {
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(Predicate.test(apple)) {
				result.add(apple);	}
		}
		return null;
	}
}
