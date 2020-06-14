package localvariables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import beans.Apple;
import function.TriFunction;

public class Ex02ContrustorReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;
		LinkedHashMap<String, Integer> map = supplier.get();
		String student = "lucian-kaisa-ekko";
		String[] filtered = Pattern.compile("-").splitAsStream(student).filter(s -> s.startsWith("l"))
				.toArray(String[]::new);
		Arrays.stream(filtered).forEach(System.out::println);
		Supplier<Apple> no = Apple::new;
		no.get();

		Function<String, Apple> func = Apple::new;
		func.apply("blue");
		List<Apple> apples = map(Arrays.asList("black", "white"), Apple::new);
		apples.forEach(System.out::println);

		TriFunction<String, String, Integer, Apple> triFunc = Apple::new;
		Apple a = triFunc.apply("yellow", "china", 222);
	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;

	}
}
