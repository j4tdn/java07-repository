package generic.wildcard;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1, "a", "b", 4d, 3);
		List<Number> numbers = Arrays.asList(1, 2, 3d, 4f, 5d);
	}
	
	private static void print(List<? extends Number> list) {
		list.forEach(item -> System.out.print(item + " "));
		System.out.println();
	}
	
	private static void show(List<? super Integer> list) {
		list.forEach(item -> System.out.print(item + " "));
		System.out.println();
	}
}
