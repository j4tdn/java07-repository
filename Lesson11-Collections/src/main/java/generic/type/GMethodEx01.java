package generic.type;

import java.util.Arrays;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
		List<Double> doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Object> objects = Arrays.asList(1, "2", 3d, "t", 5);

//		print(objects);
//		print(integers);
		
//		printT(integers);
		printT(strings);
//		printT(doubles);
//		printT(objects);

	}
	//bound type:charsequence
	private static <T extends CharSequence> void printT(List<T> ts) {
		for (T t : ts) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
	
	private static void print(List<Object> objects) {
		for (Object object : objects) {
			System.out.print(object+ " ");
		}
		System.out.println();
	}
}
