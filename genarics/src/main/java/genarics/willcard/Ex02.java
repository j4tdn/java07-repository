package genarics.willcard;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<String> first = Arrays.asList("a", "b");
		List<String> second = Arrays.asList("c", "d");
		copy(first, second);
	}

	private static <E> void copy(List<E> first, List<E> second) {
		first.addAll(second);
	}
}
