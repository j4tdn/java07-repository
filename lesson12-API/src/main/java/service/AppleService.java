package service;

import java.util.List;
import java.util.function.Predicate;

import beans.Apple;
import functions.StrategyPredicate;
public interface AppleService {
	List<Apple> getAll();

	List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate );
}
