package generics.wildcard;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<Integer> interger = Arrays.asList(1, 2, 3, 4, 5);
		List<String> string = Arrays.asList("A", "B", "C", "D", "E");
		List<Double> doubles = Arrays.asList(1.0d, 2.0d, 3.0d, 4.0d, 5.0d);
		List<Object> objects = Arrays.asList("a", 2, 4, "s");
		List<Number> numbers = Arrays.asList(54, 4, 3, 6, 3);
		print(numbers);
		

	}
	private static void print(List<? extends Number> list) {
		list.forEach(item -> System.out.print(item + " "));
		
	}
	private static void show(List<? super  Number> list) {
		list.forEach(item -> System.out.print(item + " "));
		
	}
	

}
