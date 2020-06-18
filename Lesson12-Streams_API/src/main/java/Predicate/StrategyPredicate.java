package Predicate;

@FunctionalInterface
public interface StrategyPredicate<T> {
	boolean test(T obj);
}
