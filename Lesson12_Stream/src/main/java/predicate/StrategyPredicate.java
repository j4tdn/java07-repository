package predicate;

import beans.Apple;

@FunctionalInterface
public interface StrategyPredicate<T>{
	boolean test(T apple);
}
