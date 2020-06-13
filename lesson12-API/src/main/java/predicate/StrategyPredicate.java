package predicate;

import beans.Apple;

@FunctionalInterface // để lỡ khi thay đổi và ko nên thêm những hàm trừu tượng
public interface StrategyPredicate<T> {
	boolean test(T apple );
}
