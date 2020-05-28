package generic.type;

import java.util.Arrays;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers= Arrays.asList(1,2,3,4);
		List<Double> doubles= Arrays.asList(1d,2d,3d,4d);
		List<String> strings= Arrays.asList("1","2","3","4");
		List<Object> objects= Arrays.asList(1d,"ba",2,"d");
		
		//print(integers);
		//print(objects);
		print(strings);
		//print(doubles);
	}
	private static <E extends CharSequence> void print(List<E> elements) {
		for (E e : elements) {
			System.out.print(e +" ");
		}
		System.out.println();
	}
}
