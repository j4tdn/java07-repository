package generic.type;

import java.util.Arrays;
import java.util.List;

public class GMethodEx01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1,2,3,4,5);
		List<String> strings = Arrays.asList("a","b","c","d");
		List<Double> doubles = Arrays.asList(1d,2d,3d,4d,5d);
		List<Object> objects = Arrays.asList("a", "b", 3, 5);
		
		printG(integers);
		//printG(objects);
		//printG(strings);
		printG(doubles);
				
	}
	
	private static void printO(List<Object> objects) {
		for(Object o : objects) {
			System.out.print(o + "  ");
		}
		
		System.out.println();
	}
	// bound type
	// string extend CharSquece
	private static <E extends Number> void printG(List<E> elements) {
		for(E element : elements) {
			System.out.print(element +"  ");
		}		
		System.out.println();
	}

}
