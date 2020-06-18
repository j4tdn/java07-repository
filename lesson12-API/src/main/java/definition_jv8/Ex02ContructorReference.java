package definition_jv8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import beans.Apple;
import functions.TriFunction;

public class Ex02ContructorReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;// () -> new LinkedHashMap<>();
		LinkedHashMap<String, Integer> map = supplier.get();

		String students = "phi-hung-hoang";
		String[] filter = Pattern.compile("-").splitAsStream(students).filter(s -> s.startsWith("a"))
				.toArray(String[]::new);
		Arrays.stream(filter).forEach(System.out::println);

		// contrustor with no vảiables
		Supplier<Apple> no = Apple::new;
		no.get();
		Function<String, Apple> func = Apple::new;
		func.apply("blue");

		List<Apple> apples = map(Arrays.asList("black", "white"), Apple::new);
		apples.forEach(System.out::println);
	
		TriFunction<String, String, Integer, Apple> trifunction = Apple::new;
		Apple a = trifunction.apply("yellow", "VietNam", 220);
		System.out.println(a);
		
		
	}

	// map string(origin) -> apple

	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
	
}
