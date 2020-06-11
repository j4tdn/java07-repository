package predicate;
@FunctionalInterface
public interface StrategyPredicate<T> {
	boolean test(T apple);
}
