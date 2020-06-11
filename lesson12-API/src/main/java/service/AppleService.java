package service;

import java.util.List;

import beans.Apple;
import predivate.ApplePredivate;

public interface AppleService {
	List<Apple> getAll();
	
	List<Apple> filter(List<Apple> inventory, Object predicate );

	
	
}
