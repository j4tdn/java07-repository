package generic.type;

import java.util.Arrays;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("a", "b", "c", "d", "e");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1, "b", 3d, 4, "e");

		// print(integers);
		print(strings);
		// print(objects);
		// print(doubles);
	}

	// -----------------------------------------------List<Object> chi co object
	// -------------Bound type:CharSequence
	private static <E extends CharSequence> void print(List<E> elements) {
		for (E element : elements) {
			System.out.print(element + " ");
		}
	}

}
