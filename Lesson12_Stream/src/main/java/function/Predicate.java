package function;

import beans.Apple;

@FunctionalInterface
public interface Predicate<T>{
	boolean test(T apple);
}
