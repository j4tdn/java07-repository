package generic.willcard;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1d, "b", 3d, "d", 5d);
		List<Number> numbers = Arrays.asList(1, 2d, 3f, 2, 4);

		print(numbers);
		show(numbers);
	}

	private static void print(List<? extends Number> list) {
		list.forEach(item -> System.out.println(item));
	}

	private static void show(List<? super Integer> list) {
		list.forEach(item -> System.out.println(item));
	}
}
