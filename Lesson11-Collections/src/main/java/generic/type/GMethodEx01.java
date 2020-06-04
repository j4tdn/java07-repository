package generic.type;

import java.util.Arrays;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1d, "b", 3d, "d", 5d);
		// print(objects);
		print(integers);
		// print(strings);
		print(doubles);

	}
	// Integer[] la con cua Object[] nhung List<Integer> ko phai con cua List<Object> nen dung <E>

	// neu muon chi cho Integer thi extend CharSequence
	private static <E extends Number> void print(List<E> elements) {
		for (E element : elements) {
			System.out.print(element + "  ");
		}
		System.out.println();
	}
}
