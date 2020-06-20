package functions;

@FunctionalInterface
public interface StrategyPredicate<T> {
	boolean test(T apple);
}
