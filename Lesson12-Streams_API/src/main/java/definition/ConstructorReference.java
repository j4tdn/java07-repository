package definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import beans.Apple;
import Predicate.TriFunction;

public class ConstructorReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;
		LinkedHashMap<String, Integer> linkedHashMap = supplier.get();

		String students = "join-adam-anie";
		String[] filtered = Pattern.compile("-").splitAsStream(students).filter(s -> s.startsWith("a"))
				.toArray(String[]::new);
//		for (String string : filtered) {
//			System.out.println(string);
//		}
		Arrays.stream(filtered).forEach(System.out::println);
		
		Function<String, Apple> function = Apple::new;
		function.apply("green");
		System.out.println("=================");
		
		List<Apple> apples = map(Arrays.asList("green", "red"), Apple::new);
		apples.forEach(System.out::println);
		System.out.println("=================");
		
		Predicate.TriFunction<String, String, Integer, Apple> triFunction = Apple::new;
		Apple apple = triFunction.apply("green", "VN", 100);
		System.out.println(apple);
		
	}
	private static<T, R> List<R> map (List<T> ts, Function<T, R> function) {
		List<R> results = new ArrayList<>();
		for (T t: ts) {
			results.add(function.apply(t));
		}
		return results;
	}
}
