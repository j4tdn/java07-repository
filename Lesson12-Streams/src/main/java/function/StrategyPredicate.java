package function;

@FunctionalInterface // la interface chi co 1 ham truu tuong (con 1 hay nhieu ham default hay static
						// ko quan trong),
					 // co the thay the bang 1 lamda
public interface StrategyPredicate<T> {
	boolean test(T apple);
}