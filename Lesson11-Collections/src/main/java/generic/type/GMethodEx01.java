package generic.type;

import java.util.Arrays;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
//		List<String> strings = Arrays.asList("a", "b", "c", "d");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
//		List<Object> objects = Arrays.asList(1d, 2, "c", 4d, "e");

		print(integers);
//		print(strings);
		print(doubles);
//		print(objects);
	}
//	bound type: Number(Integer, Double, ...)
	private static <E extends Number> void print(List<E> e) {
		for (E element : e) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}