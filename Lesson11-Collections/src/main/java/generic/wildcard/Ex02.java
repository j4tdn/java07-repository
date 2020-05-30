package generic.wildcard;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("a", "b");
		List<String> second = Arrays.asList("c", "d");

		first.addAll(second);
		copy(first, second);
	}

	private static <E> void copy(List<E> first, List<? extends E > second) {
		first.addAll(second);
	}

}
