package service;

import java.util.List;

import Predicate.StrategyPredicate;
import beans.Apple;

public interface AppleService {

	List<Apple> getAll();

	List<Apple> filter(List<Apple> inventory, StrategyPredicate<Apple> predicate);
}
