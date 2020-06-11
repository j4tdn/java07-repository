package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Apple;
import dao.AppleDao;
import dao.AppleDaoimpl;
import predivate.ApplePredivate;

public class AppleSeviceImpl implements AppleService {

		private AppleDao dao =  new AppleDaoimpl();
	@Override
	public List<Apple> getAll() {
		// load data from datebasse => sevice
		return null;
	}
	public List<Apple> filter(List<Apple> inventory, ApplePredivate predivate) {
		if(inventory == null || inventory.isEmpty() || predivate == null) {
			return Collections.emptyList();
		}
		
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(predivate.test(apple))
				result.add(apple);
		}
		return null;
	}
	@Override
	public List<Apple> filter(List<Apple> inventory, Apple predivate) {
		// TODO Auto-generated method stub
		return null;
	}

}
