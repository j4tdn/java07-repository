package definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import beans.Apple;
import functions.TriFunction;

public class Ex02ContructerReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;
		LinkedHashMap<String, Integer> map = supplier.get();

		String students = "ekko-fizz-lucian-pantheon";
		String[] str = Pattern.compile("-").splitAsStream(students).filter(s -> s.startsWith("e"))
				.toArray(String[]::new);
		Arrays.stream(str).forEach(System.out::println);

		// constructor with no variable
		Supplier<Apple> sup = Apple::new;

		// constructor with 1 variable
		Function<String, Apple> func = Apple::new;
		func.apply("blue");

		List<Apple> app = map(Arrays.asList("black", "white"), Apple::new);
		app.forEach(System.out::println);

		TriFunction<String, String, Integer, Apple> tri = Apple::new;
		Apple a = tri.apply("blue", "VN", 150);
		System.out.println("a: " + a);
	}

	// map string(origin) -> apple
	private static <T, R> List<R> map(List<T> ts, Function<T, R> fun) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(fun.apply(t));
		}
		return result;
	}
}