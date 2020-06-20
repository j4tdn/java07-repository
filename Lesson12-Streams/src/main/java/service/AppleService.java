package service;

import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import functions.StrategyPredicate;

public interface AppleService {
	// interface access modifier default is public
	
	List<Apple> getAll();
	
	List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate);

}
