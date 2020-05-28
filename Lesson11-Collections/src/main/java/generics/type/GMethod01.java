package generics.type;

import java.util.Arrays;
import java.util.List;

public class GMethod01 {
	public static void main(String[] args) {
		List<Integer> interger = Arrays.asList(1, 2, 3, 4, 5);
		List<String> string = Arrays.asList("A", "B", "C", "D", "E");
		List<Double> doubles = Arrays.asList(1.0d, 2.0d, 3.0d, 4.0d, 5.0d);
		List<Object> objects = Arrays.asList("a", 2, 4, "s");

		// print(interger);
		// print(objects);
		// print(doubles);
		print(string);

	}

//bound type : charsequence
	private static <E extends CharSequence> void print(List<E> element) {
		for (E e : element) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

}
