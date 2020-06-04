package generic.type28;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class GMEx01 {
	public static void main(String[] args) {
		List<Integer> integer = Arrays.asList(1,2,3,4,5);
		List<String> strings = Arrays.asList("1", "2", "3","4");
		List<Double> doubles = Arrays.asList(1d,2d,3d,4d);
		List<Object> objects = Arrays.asList(1,"a",2,"b");
//		print(objects);
//		print(doubles);
//		print(integer);
		print(strings);
		//bound type: CharSequence
		
		
	}
	private static <E extends CharSequence > void print(List<E> elements ) {
		for(E element: elements) {
			System.out.print(element+" ");
		}
		System.out.println();
	}
}
