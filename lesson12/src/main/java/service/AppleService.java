package service;

import java.util.List;
import java.util.function.Predicate;

import Predicate.StrategyPredicate;
import beans.Apple;

public interface AppleService {

	List<Apple> getAll();

	List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate);
}
