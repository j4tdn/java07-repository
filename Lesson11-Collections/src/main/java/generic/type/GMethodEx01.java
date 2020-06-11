package generic.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1d, "b", 3d, "d", 5d);
		
		Collections.sort(integers);
		
		// print(integers);
		print(strings);
		// print(doubles);
		// print(objects);
	}
	
	// bound type: CharSequence
	private static <E extends CharSequence> void print(List<E> elements) {
		for (E element: elements) {
			System.out.print(element + "   ");
		}
		System.out.println();
	}
	
	private static void printWillCard(List<?> elements) {
		for (Object element: elements) {
			System.out.print(element + "   ");
		}
		System.out.println();
	}
}
