package generic.willcard;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	
	public static void main(String[] args) {
		List<String> first = Arrays.asList("a", "b", "c");
		List<String> second = Arrays.asList("d", "e");
		
		coppy(first, second);
		
	}

	private static <E> void coppy(List<E> target, List<? extends E> source) {
		target.addAll(source);
	}
}
