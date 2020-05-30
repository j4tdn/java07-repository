package generic.willcard;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1,2,3,4,5);
		List<String> strings = Arrays.asList("a","b","c","d");
		List<Double> doubles = Arrays.asList(1d,2d,3d,4d,5d);
		List<Object> objects = Arrays.asList("a", "b", 3, 5);
		List<Number> numbers = Arrays.asList(1, 3f, 4, 5d);
		
		print(strings);
		show(objects);
	}
	
	private static void print(List<? extends CharSequence> list) {
		list.forEach(item -> System.out.print(item + "  "));
	}

	private static void show(List<? super CharSequence> list) {
		list.forEach(item -> System.out.print(item + "  "));
	}
	
}
