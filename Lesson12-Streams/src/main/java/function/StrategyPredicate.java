package function;

@FunctionalInterface
public interface StrategyPredicate<T> {
	boolean test(T obj);
}
