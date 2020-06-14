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

public class ConstructorReference {
	public static void main(String[] args) {
		Supplier<LinkedHashMap<String, Integer>> supplier = LinkedHashMap::new;
		LinkedHashMap<String, Integer> map = supplier.get();
		
		String students = "join-adam-anne";
		String[] filtered = Pattern.compile("-").splitAsStream(students)
				.filter(s -> s.startsWith("a"))
				.toArray(String[]::new);
		Arrays.stream(filtered).forEach(System.out::println);
		
		//constructor with none variables
		Supplier<Apple> none = Apple::new;
		none.get();
		
		//constructor with 1 variables
		Function<String, Apple> func = Apple::new;
		func.apply("blue");
		
		TriFunction<String, String, Integer, Apple> triFunc = Apple::new;
		Apple a = triFunc.apply("red", "VietNam", 80);
		System.out.println(a);
		
		List<Apple> apples = map(Arrays.asList("black", "white"), Apple::new); 
		apples.forEach(System.out::println);
	}
	
	//map string(origin) -> Apple
	private static <T, R> List<R> map(List<T> ts, Function<T, R> func) {
		List<R> result = new ArrayList<>();
		for (T t : ts) {
			result.add(func.apply(t));
		}
		return result;
	}
}
