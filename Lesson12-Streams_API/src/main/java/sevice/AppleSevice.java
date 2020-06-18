package sevice;

import java.util.List;

import beans.Apple;


import Predicate.StrategyPredicate;

public interface AppleSevice {
	List<Apple> getAll();
	List<Apple> filter (List<Apple> inventory, StrategyPredicate<Apple> predicate);
}
