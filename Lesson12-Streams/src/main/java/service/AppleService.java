package service;

import java.util.List;

import bean.Apple;
import predicate.StrategyPredicate;

public interface AppleService {
	//interface access modifier default: public
	 List<Apple> getAll();
	 
	 List<Apple> filter(List<Apple> inventory,StrategyPredicate<Apple> predicate);
}
