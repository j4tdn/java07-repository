package service;

import java.util.List;

import beans.Apple;
import predicate.StrategyPredicate;

public interface AppleService {
	// inteface access modifier default: public 
	List<Apple> getAll();
	List<Apple> filter(List<Apple> inventory, StrategyPredicate<Apple> predicate);
}
