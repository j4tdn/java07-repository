package generics.willcard;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("a", "b");
		List<String> second = Arrays.asList("b", "c");
		// first.addAll(second);
		copy(first, second);
	}

	private static <E, T> void copy(List<E> target, List<? extends E> source) {
		// first.addAll(second);
		target.addAll(source);
	}

}
