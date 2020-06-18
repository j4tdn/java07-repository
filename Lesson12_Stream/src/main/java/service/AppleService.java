package service;

import java.util.List;
import java.util.function.Predicate;

import beans.Apple;

public interface AppleService {
	
	//interface access modifier default:public
	List<Apple> getAll();
	List<Apple> filter(List<Apple> inventory,Predicate<Apple> predicate);
}
