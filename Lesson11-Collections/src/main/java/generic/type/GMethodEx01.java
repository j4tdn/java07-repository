package generic.type;

import java.util.Arrays;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1, "a", "b", 4d, 3);
		show(integers);
		//show(strings);
		show(doubles);
		//show(objects);
	}
	
	//bound type: Number
	private static <E extends Number> void show(List<E> elements) {
		for (E e : elements) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
