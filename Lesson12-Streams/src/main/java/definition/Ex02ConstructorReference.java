package definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import beans.Apple;
import function.TriFunction;

public class Ex02ConstructorReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;// () -> new LinkedHashMap<>()
		LinkedHashMap<String, Integer> map = supplier.get();

		String students = "john-adam-anne";
		String[] filtered = Pattern.compile("-").splitAsStream(students).filter(s -> s.startsWith("a"))
				.toArray(String[]::new);
		// Arrays.asList(filtered).forEach(System.out::println);
		Arrays.stream(filtered).forEach(System.out::println);

		// constructor no variables
		Supplier<Apple> no = Apple::new;
		no.get();

		// constructor 1 variables
		Function<String, Apple> func = Apple::new;
		func.apply("blue");

		System.out.println("================================");
		List<Apple> apples = map(Arrays.asList("black", "white"), Apple::new);
		apples.forEach(System.out::println);

		System.out.println("================================");
		TriFunction<String, String, Integer, Apple> triFunc = Apple::new;
		Apple a = triFunc.apply("pink", "VietNam", 200);
		System.out.println(a);

	}

	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
}
