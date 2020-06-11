package predicate;

import beans.Apple;

@FunctionalInterface
public interface StrateryPredicate<T> {
	boolean test(T apple);
}
