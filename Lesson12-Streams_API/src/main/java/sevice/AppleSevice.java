package sevice;

import java.util.List;
import java.util.function.Predicate;

import beans.Apple;


import Predicate.StrategyPredicate;

public interface AppleSevice {
	List<Apple> getAll();
	List<Apple> filter (List<Apple> inventory, Predicate<Apple> weightPre);
	List<Apple> filter(List<Apple> inventory, StrategyPredicate<Apple> predicate);
}
