package service;

import java.util.List;

import beans.Apple;
import predicate.StrateryPredicate;

public interface AppleService {
	//interface access modifier default: public
	List<Apple> getAll(); 
	
	List<Apple> filter(List<Apple> inventory, StrateryPredicate<Apple> predicate);
}
