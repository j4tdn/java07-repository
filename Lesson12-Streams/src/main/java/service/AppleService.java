package service;

import java.util.List;
import beans.Apple;
import functions.StrategyPredicate;

public interface AppleService {
	// interface access modifier default is public
	
	List<Apple> getAll();
	
	List<Apple> filter(List<Apple> inventory, StrategyPredicate<Apple> predicate);

}
