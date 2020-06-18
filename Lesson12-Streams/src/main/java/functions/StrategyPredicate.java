package functions;

import bean.Apple;

@FunctionalInterface
public interface StrategyPredicate<T> {
	boolean test(T apple);
}
